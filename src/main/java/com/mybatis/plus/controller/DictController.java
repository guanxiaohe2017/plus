package com.mybatis.plus.controller;


import com.mybatis.plus.dto.ExcelDto;
import com.mybatis.plus.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gch
 * @since 2020-01-15
 */
@RestController
@RequestMapping("/plus/dict")
public class DictController {

    @Autowired
    private IDictService iDictService;

//    @RequestMapping(value = "importExcel", consumes = "application/json")
    @RequestMapping("importExcel")
    public String importExcel(){
        iDictService.importExcel();
        return "success";
    }

}

