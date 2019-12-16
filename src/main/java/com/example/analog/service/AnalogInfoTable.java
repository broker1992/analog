package com.example.analog.service;

public interface AnalogInfoTable {

    //根据查询结果判断时候创建表AnaogInfo
    /**
     * 1.查询表是否存在
     * 2.不存在直接创建表
     */
    String createTableAnalogInfo();
}
