package com.example.analog.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.analog.model.AnalogInfo;
import com.example.analog.service.AnalogInfoService;
import org.apache.tomcat.util.buf.MessageBytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${pathNative}")
    String pathNative;
    @Autowired
    AnalogInfoService analogInfoService;

    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //从这里获取请求连接中的url
        String path = request.getRequestURI();
        LOG.info("path= "+path);

        Object a = findCoyoteRequest(request);
        Field coyoteRequest = a.getClass().getDeclaredField("coyoteRequest");
        coyoteRequest.setAccessible(true);
        Object b = coyoteRequest.get(a);

        Field uriMB = b.getClass().getDeclaredField("uriMB");
        uriMB.setAccessible(true);
        MessageBytes c = (MessageBytes)uriMB.get(b);
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        Map<String,Object> map = new HashMap<>();
        //查询外部url
        List<AnalogInfo> analogInfos = analogInfoService.queryByPath(c.getString());
        if(analogInfos.size()==1){
            LOG.info("接口存在");
            //验证接口方法

            //判断当前接口状态-返回对应的返回值
            switch (analogInfos.get(0).getStatus()){
                case 0:
                    writer.write(analogInfos.get(0).getReturnCode());
                    break;
                case 1:
                    writer.write(analogInfos.get(0).getError1());
                    break;
                case 2:
                    writer.write(analogInfos.get(0).getError2());
                    break;
                case 3:
                    writer.write(analogInfos.get(0).getError3());
                    break;
                default:
                    writer.write(analogInfos.get(0).getReturnCode());
            }


        }else{
            LOG.info("查询到的接口数量："+analogInfos.size());
            map.put("state","E");
            map.put("message","接口地址错误,查到的接口数量："+analogInfos.size());
            writer.write(JSON.toJSONString(map));
        }



        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private Class getClassByName(Class classObject, String name){
        Map<Class,List<Field>> fieldMap = new HashMap<>();
        Class returnClass = null;
        Class tempClass = classObject;
        while (tempClass != null) {
            fieldMap.put(tempClass,Arrays.asList(tempClass .getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }

        for(Map.Entry<Class,List<Field>> entry: fieldMap.entrySet()){
            for (Field f : entry.getValue()) {
                if(f.getName().equals(name)){
                    returnClass = entry.getKey();
                    break;
                }
            }
        }
        return returnClass;
    }

    private Object findCoyoteRequest(Object request)  throws Exception {
        Class a = getClassByName(request.getClass(), "request");
        Field request1 = a.getDeclaredField("request");
        request1.setAccessible(true);
        Object b = request1.get(request);
        if (getClassByName(b.getClass(), "coyoteRequest") == null) {
            return findCoyoteRequest(b);
        } else {
            return b;
        }
    }
}
