package com.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.entity.order.CheckOrder;
import com.mybatis.plus.mapper.order.CheckOrderMapper;
import com.mybatis.plus.service.CheckOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CheckOrderServiceImpl extends ServiceImpl<CheckOrderMapper, CheckOrder> implements CheckOrderService{

    @Autowired
    private CheckOrderMapper checkOrderMapper;

    @Override
    public List<HashMap<String,String>> invokeSql(String sqlString) {
        return checkOrderMapper.invokeSql(sqlString);
    }

    @Override
    public List<CheckOrder> listCheckOrders() {
//        this.saveOrUpdate();
        return list();
    }
}
