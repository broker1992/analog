package com.example.analog.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.analog.dao.AnalogMapper;
import com.example.analog.model.AnalogInfo;
import com.example.analog.model.DownloadParam;
import com.example.analog.service.AnalogInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("AnalogInfoService")
public class AnalogInfoServiceImpl implements AnalogInfoService {

    @Autowired
    private AnalogMapper analogMapper;

    private static final Logger LOG = LoggerFactory.getLogger(AnalogInfoServiceImpl.class);
    @Override
    public List<AnalogInfo> queryByPath(String path) {
        if(path  == null){
            LOG.error("path == null,查询所有");

        }
        List<AnalogInfo> list =analogMapper.queryByPath(path);
        for (int i = 0; i < list.size() ; i++) {
            LOG.info("结果："+list.get(i).toString());
        }
        return analogMapper.queryByPath(path);
    }

    @Override
    public String queryAllPath(AnalogInfo analogInfo) {
        int i = 0;
        Map<String,Object> map = new HashMap<>();
        try{
            List<AnalogInfo> list = analogMapper.queryAllPath(analogInfo);
            for (int j = 0; j < list.size(); j++) {
                LOG.info("查询结果："+list.get(j).toString());
            }
            map.put("list",list);
            map.put("status","S");
        } catch (Exception e){
            e.printStackTrace();
            LOG.error("查询接口信息失败");
            map.put("status","E");
        }

        return JSON.toJSONString(map);
    }

    @Override
    public String addAnalogInfo(AnalogInfo analogInfo) {
        int i = 0;
        Map<String,String> map = new HashMap<>();
        try{
            i = analogMapper.addAnalogInfo(analogInfo);

        } catch (Exception e){
            map.put("state","error");
            map.put("msg",e.getMessage());
            e.printStackTrace();
            return JSON.toJSONString(map);
        }
        LOG.info("插入结果影响行数="+i);
        if(i > 0){
            LOG.info("插入成功");
            map.put("state","success");
        }else{
            LOG.info("插入失败");
            map.put("state","fail");
        }
        return JSON.toJSONString(map);
    }

    @Override
    public String updateAnalogInfo(AnalogInfo analogInfo) {
        int i = 0;
        Map<String,String> map = new HashMap<>();
        try{
            i = analogMapper.updateAnalogInfo(analogInfo);
        }catch (Exception e){
            e.printStackTrace();
            map.put("state","error");
            map.put("msg",e.getMessage());
            return JSON.toJSONString(map);
        }
        LOG.info("更新数量结果影响行数="+i);
        if(i > 0){
            LOG.info("更新数量成功");
            map.put("state","success");
        }else{
            LOG.info("更新数量失败");
            map.put("state","fail");
        }
        return JSON.toJSONString(map);
    }

    @Override
    public String deleteAnalogInfo(BigInteger id) {
        int i = 0;
        Map<String,String> map = new HashMap<>();
        try{
            i = analogMapper.deleteAnalogInfo(id);
        }catch (Exception e){
            e.printStackTrace();
            map.put("state","error");
            map.put("msg",e.getMessage());
            return JSON.toJSONString(map);
        }
        LOG.info("删除接口结果影响行数="+i);
        if(i > 0){
            LOG.info("删除成功");
            map.put("state","success");
        }else{
            LOG.info("删除失败");
            map.put("state","fail");
        }
        return JSON.toJSONString(map);
    }


}
