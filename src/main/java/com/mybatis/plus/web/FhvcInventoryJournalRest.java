package com.mybatis.plus.web;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.plus.entity.consumables.FhvcInventory;
import com.mybatis.plus.entity.consumables.FhvcInventoryJournal;
import com.mybatis.plus.mapper.consumables.FhvcInventoryJournalMapper;
import com.mybatis.plus.mapper.consumables.FhvcInventoryMapper;
import com.mybatis.plus.service.FhvcInventoryJournalService;
import com.mybatis.plus.service.FhvcInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fhvcInventoryJournal")
public class FhvcInventoryJournalRest {
    @Resource
    FhvcInventoryJournalMapper fhvcInventoryJournalMapper;

    @Resource
    FhvcInventoryJournalService fhvcInventoryJournalService;

    @RequestMapping("list")
    public String list(){
        String cstId = "55d254278d01b2916636cd58428354df";

        long start1 = System.currentTimeMillis();

        List<FhvcInventoryJournal> fhvcInventoryJournals = fhvcInventoryJournalService.list((new QueryWrapper<FhvcInventoryJournal>()).eq("cst_id", cstId));

        Console.log(fhvcInventoryJournals);
        Console.log(fhvcInventoryJournals.size());
        String end1 = "start1" + (System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        fhvcInventoryJournalService.listByIds(fhvcInventoryJournals.stream().map(fhvcInventoryJournal ->
                fhvcInventoryJournal.getJournalId()).collect(Collectors.toList()));
        String end2 = "start2" + (System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        List<FhvcInventoryJournal> journals = new ArrayList<>();
        for (FhvcInventoryJournal inventoryJournal : fhvcInventoryJournals) {
            FhvcInventoryJournal byId = fhvcInventoryJournalService.getById(inventoryJournal.getJournalId());
            journals.add(byId);
        }
        String end3 = "start3" + (System.currentTimeMillis() - start3);

        Console.log(end1);
        Console.log(end2);
        Console.log(end3);

        return "success";
    }
}
