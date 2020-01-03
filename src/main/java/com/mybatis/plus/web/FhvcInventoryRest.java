package com.mybatis.plus.web;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.plus.entity.consumables.FhvcInventory;
import com.mybatis.plus.entity.order.CheckOrder;
import com.mybatis.plus.mapper.consumables.FhvcInventoryMapper;
import com.mybatis.plus.mapper.order.CheckOrderMapper;
import com.mybatis.plus.service.CheckOrderService;
import com.mybatis.plus.service.FhvcInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fhvcInventory")
public class FhvcInventoryRest {
    @Resource
    FhvcInventoryMapper fhvcInventoryMapper;

    @Resource
    FhvcInventoryService fhvcInventoryService;

    @RequestMapping("list")
    public String list(){
        String cstId = "55d254278d01b2916636cd58428354df";

        List<FhvcInventory> fhvcInventories = fhvcInventoryService.list((new QueryWrapper<FhvcInventory>()).eq("cst_id", cstId));

        Console.log(fhvcInventories);

        Console.log(fhvcInventories.size());

        return "success";
    }
}
