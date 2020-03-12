package com.example.analog.controller;

import com.example.analog.model.AnalogInfo;
import com.example.analog.model.DownloadParam;
import com.example.analog.service.AnalogInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/analog")
public class AnalogController {

    @Autowired
    private AnalogInfoService analogInfoService;
    //接口信息的增删改查

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addAnalog(@RequestBody AnalogInfo analogInfo){

        return analogInfoService.addAnalogInfo(analogInfo);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String deleteAnalog(@RequestBody BigInteger id){
        return analogInfoService.deleteAnalogInfo(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateAnalog(@RequestBody AnalogInfo analogInfo){
        return analogInfoService.updateAnalogInfo(analogInfo);
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String queryAnalog(@RequestBody AnalogInfo analogInfo){
        return analogInfoService.queryAllPath(analogInfo);
    }




}
