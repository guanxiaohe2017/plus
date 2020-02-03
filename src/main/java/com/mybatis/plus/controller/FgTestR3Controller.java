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

    @RequestMapping("changeTimeliness")
    public String changeTimeliness(){
        iFgTestR3Service.changeTimeliness();
        return "success";
    }

    @RequestMapping("test")
    public String test(){
//        iFgTestR3Service.changeTimeliness();
        return "success";
    }

    @RequestMapping("addType")
    public String addType(){
        iFgTestR3Service.addType();
        return "success";
    }

    @RequestMapping("deleteSHWD")
    public String deleteSHWD(){
        iFgTestR3Service.deleteSHWD();
        return "success";
    }

    /**
     * @author: 官昌洪
     * @Description: 批量设置文章时效性、行业、税种
     * @Date: 2020/1/16 10:07
     * @Param: type-设置种类（timeliness-时效性；industry-行业；taxType-税种），webGuid-网站编号
     * @return:
     */
    @RequestMapping("addDimension")
    public String addDimension(String type, String webGuid) {
        iFgTestR3Service.addDimension(type, webGuid);
        return "success";
    }

    /**
     * @author: 官昌洪
     * @Description: 去重法规
     * @Date: 2020/1/16 10:07
     * @Param:
     * @return:
     */
    @RequestMapping("removeRepeatItems")
    public String removeRepeatItems() {
        iFgTestR3Service.removeRepeatItems();
        return "success";
    }

}

