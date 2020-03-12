package com.example.analog.service;

import com.example.analog.model.AnalogInfo;
import com.example.analog.model.DownloadParam;

import java.math.BigInteger;
import java.util.List;

public interface AnalogInfoService {

    //按照路径 查询出
    List<AnalogInfo> queryByPath(String path);

    //查询所有+条件查询
    String queryAllPath(AnalogInfo analogInfo);

    //新增接口
    String addAnalogInfo(AnalogInfo analogInfo);

    //更新接口
    String updateAnalogInfo(AnalogInfo analogInfo);

    //删除接口
    String deleteAnalogInfo(BigInteger id);


}
