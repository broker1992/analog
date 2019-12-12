package com.example.analog.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.analog.model.AnalogInfo;
import com.example.analog.service.AnalogInfoService;
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
        if(pathNative.contains(path)){

            LOG.info("内部url");
            return true;
        }else{
            LOG.info("外部url");
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter writer = response.getWriter();
            Map<String,Object> map = new HashMap<>();
            //查询外部url
            List<AnalogInfo> analogInfos = analogInfoService.queryByPath(path);
            if(analogInfos.size()==1){
                LOG.info("接口存在");
                LOG.info("返回值："+analogInfos.get(0).getReturnCode());
                map.put("state","S");
                map.put("return",analogInfos.get(0).getReturnCode());

            }else{
                LOG.info("查询到的接口数量："+analogInfos.size());
                map.put("state","E");
                map.put("message","接口地址错误,查到的接口数量："+analogInfos.size());

            }
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


}
