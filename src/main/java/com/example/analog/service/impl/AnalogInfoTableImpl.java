package com.example.analog.service.impl;

import com.example.analog.dao.AnalogDDLMapper;
import com.example.analog.service.AnalogInfoTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AnalogInfoTableImpl implements AnalogInfoTable {

    @Value("${createTable.AnalogInfo.flag:false}")
    Boolean flag;
    @Autowired
    private AnalogDDLMapper analogDDLMapper;
    private static final Logger LOG = LoggerFactory.getLogger(AnalogInfoTableImpl.class);
    @Override
    @PostConstruct
    public String createTableAnalogInfo() {

        if(!flag){
            LOG.info("flag="+flag);
            return null;
        }else{
            LOG.info("开始创建表");
            try{
                //查看数据库中是否存在表
                int i = analogDDLMapper.checkTable("analog_info");
                if(i == 1){ //表存在
                    LOG.info("表存在");
                    return null;
                }else{
                    LOG.info("表不存在，开始创建");
                    analogDDLMapper.createTableAnalogInfo("analog_info");
                    LOG.info("表创建完成");
                    int j = analogDDLMapper.checkTable("analog_info");
                    if(j ==1){
                        return "表创建完成";
                    }else{
                        return "表创建失败";
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
