package com.mybatis.plus.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mybatis.plus.entity.FgTestR3;
import com.mybatis.plus.service.IFgTestR3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 法规表 前端控制器
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/plus/fg-test-r3")
public class FgTestR3Controller {
    @Autowired
    private IFgTestR3Service iFgTestR3Service;


    @RequestMapping("listContent")
    public String listContent(long id){
        FgTestR3 byId = iFgTestR3Service.getById(id);
        String content = byId.getContents();
//        String replace = content.replace("　　", "\n\n");
        return content;
    }

    @RequestMapping("formatContent")
    public String formatContent(){
//        FgTestR3 byId = iFgTestR3Service.getById(63L);
//        String content = byId.getContents();
//        String replace = content.replace("　　", "\n\n");
//        iFgTestR3Service.formatContentContainsWd();
        return "success";
    }

    @RequestMapping("moveToWd")
    public String moveToWd(){
        iFgTestR3Service.moveToWd();

        return "success";
    }

    @RequestMapping("fixFg")
    public String fixFg(){
        iFgTestR3Service.fixFg();

        return "success";
    }
}

