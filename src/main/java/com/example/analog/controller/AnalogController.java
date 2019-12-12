package com.example.analog.controller;

import com.example.analog.model.AnalogInfo;
import com.example.analog.service.AnalogInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class AnalogController {

    @Autowired
    private AnalogInfoService analogInfoService;
    //接口信息的增删改查

    @RequestMapping(value = "/addAnalog",method = RequestMethod.POST)
    public String addAnalog(@RequestBody AnalogInfo analogInfo){

        return analogInfoService.addAnalogInfo(analogInfo);
    }

    @RequestMapping(value = "/deleteAnalog",method = RequestMethod.DELETE)
    public String deleteAnalog(@RequestBody BigInteger id){
        return analogInfoService.deleteAnalogInfo(id);
    }

    @RequestMapping(value = "/updateAnalog", method = RequestMethod.PUT)
    public String updateAnalog(@RequestBody AnalogInfo analogInfo){
        return analogInfoService.updateAnalogInfo(analogInfo);
    }

    @RequestMapping(value = "/queryAnalog", method = RequestMethod.GET)
    public List<AnalogInfo> queryAnalog(@RequestParam(required = false) String path){
        return analogInfoService.queryByPath(path);
    }
}
