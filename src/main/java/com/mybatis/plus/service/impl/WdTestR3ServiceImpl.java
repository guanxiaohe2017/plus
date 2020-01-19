package com.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.plus.entity.WdTestR3;
import com.mybatis.plus.mapper.WdTestR3Mapper;
import com.mybatis.plus.service.IFgTestR3Service;
import com.mybatis.plus.service.IWdTestR3Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 问答表 服务实现类
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Service
public class WdTestR3ServiceImpl extends ServiceImpl<WdTestR3Mapper, WdTestR3> implements IWdTestR3Service {

    @Autowired
    private IFgTestR3Service iFgTestR3Service;

    @Autowired
    private IWdTestR3Service wdTestR3Service;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void formatContent() {
        List<WdTestR3> wdTestR3s = wdTestR3Service.list((new QueryWrapper<WdTestR3>()).eq("webGuid", "103"));
        for (WdTestR3 wdTestR3 : wdTestR3s) {
            String a = wdTestR3.getRequestContent();
            String q = wdTestR3.getResponseContent();
            wdTestR3.setResponseContent(a);
            wdTestR3.setRequestContent(q);
        }
        wdTestR3Service.updateBatchById(wdTestR3s);
    }
}
