package com.mybatis.plus.controller;


import com.mybatis.plus.service.IFgTestR3Service;
import com.mybatis.plus.service.IWdTestR3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 问答表 前端控制器
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@RestController
@RequestMapping("/plus/wd-test-r3")
public class WdTestR3Controller {

    @Autowired
    private IWdTestR3Service iWdTestR3Service;

    @RequestMapping("formatContent")
    public String formatContent(){
        iWdTestR3Service.formatContent();
        return "success";
    }

}

