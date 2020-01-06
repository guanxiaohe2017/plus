package com.mybatis.plus.controller;


import com.mybatis.plus.entity.Area;
import com.mybatis.plus.entity.FgTestR3;
import com.mybatis.plus.entity.WdTestR3;
import com.mybatis.plus.service.IAreaService;
import com.mybatis.plus.service.IFgTestR3Service;
import com.mybatis.plus.service.IWdTestR3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/plus/area")
public class AreaController {

    @Autowired
    IWdTestR3Service wdTestR3Service;

    @Autowired
    IFgTestR3Service fgTestR3Service;

    @Autowired
    IAreaService areaService;

    @RequestMapping("wdAddAreaId")
    public String wdAddAreaId(){
        areaService.wdAddAreaId();
        return "ok";
    }

    @RequestMapping("fgAddAreaId")
    public String fgAddAreaId(){
        areaService.fgAddAreaId();
        return "ok";
    }


}

