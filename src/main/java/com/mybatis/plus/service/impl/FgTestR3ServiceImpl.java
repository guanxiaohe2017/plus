package com.mybatis.plus.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mybatis.plus.entity.FgTestR3;
import com.mybatis.plus.entity.WdTestR3;
import com.mybatis.plus.mapper.FgTestR3Mapper;
import com.mybatis.plus.service.IFgTestR3Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.service.IWdTestR3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 法规表 服务实现类
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Service
public class FgTestR3ServiceImpl extends ServiceImpl<FgTestR3Mapper, FgTestR3> implements IFgTestR3Service {

    @Autowired
    private IFgTestR3Service iFgTestR3Service;

    @Autowired
    private IWdTestR3Service wdTestR3Service;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void formatContent() {
        List<FgTestR3> list = iFgTestR3Service.list();
        List<FgTestR3> saveList = new ArrayList<>();
        for (FgTestR3 fgTestR3 : list) {
            String content = fgTestR3.getContents();
            if (StringUtils.isNotEmpty(content)) {
                fgTestR3.setContents(content.replace("　　", "\n\n"));
            }
            saveList.add(fgTestR3);
        }
        iFgTestR3Service.updateBatchById(saveList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void formatContentContainsWd() {
        QueryWrapper<FgTestR3> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("clicks",3);
        List<FgTestR3> list = iFgTestR3Service.list(queryWrapper);
        List<FgTestR3> saveList = new ArrayList<>();
        for (FgTestR3 fgTestR3 : list) {
            String content = fgTestR3.getContents();
            if (StringUtils.isNotEmpty(content)) {
                fgTestR3.setContents(content.replace("？", "？\n"));
            }
            saveList.add(fgTestR3);
        }
        iFgTestR3Service.updateBatchById(saveList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void moveToWd() {
        List<FgTestR3> fgTestR3s = iFgTestR3Service
                .list((new QueryWrapper<FgTestR3>()).eq("clicks", "3"));

        List<WdTestR3> wdTestR3s = new ArrayList<>();
        for (FgTestR3 fgTestR3 : fgTestR3s) {
            WdTestR3 wdTestR3 = new WdTestR3();
            wdTestR3.setGuids(fgTestR3.getGuids());
            wdTestR3.setTitles(fgTestR3.getTitles());
            wdTestR3.setResponseTime(DateUtil.parseDate(fgTestR3.getYears()));
            wdTestR3.setContents(fgTestR3.getContents());
            wdTestR3.setSourceURL(fgTestR3.getSourceUrl());
            wdTestR3.setWebGuid(fgTestR3.getWebGuid());
            wdTestR3s.add(wdTestR3);
            wdTestR3Service.save(wdTestR3);
        }
//        wdTestR3Service.saveBatch(wdTestR3s);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void fixFg() {
        QueryWrapper<FgTestR3> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("webGuid","103","105","106","107","108");
        queryWrapper.isNotNull("collectFjName");
        queryWrapper.ne("collectFjName","");
        List<FgTestR3> list = iFgTestR3Service.list(queryWrapper);

        for (FgTestR3 fgTestR3 : list) {
            fgTestR3.setAttachmentesUrl(fgTestR3.getCollectFjName());
            fgTestR3.setFjCollectionDate(LocalDateTime.now());
            fgTestR3.setIscollectionFJ("是");
            String name = fgTestR3.getCollectFjName();
            StringBuilder regex = new StringBuilder();
            if (name.contains("103")) {
                regex.append("\\");
                regex.append("Files");
                regex.append("\\");
                regex.append("103");
                regex.append("\\");
            } else if (name.contains("105")) {
                regex.append("\\");
                regex.append("Files");
                regex.append("\\");
                regex.append("105");
                regex.append("\\");
            } else if (name.contains("106")) {
                regex.append("\\");
                regex.append("Files");
                regex.append("\\");
                regex.append("106");
                regex.append("\\");
            } else if (name.contains("107")) {
                regex.append("\\");
                regex.append("Files");
                regex.append("\\");
                regex.append("107");
                regex.append("\\");
            } else if (name.contains("108")) {
                regex.append("\\");
                regex.append("F");
                regex.append("iles");
                regex.append("\\");
                regex.append("108");
                regex.append("\\");
            }

            fgTestR3.setAttachmentesName(name.replace(regex.toString(),""));
        }

        iFgTestR3Service.updateBatchById(list);
    }
}
