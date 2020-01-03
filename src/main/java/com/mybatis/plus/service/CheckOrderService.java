package com.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.plus.entity.order.CheckOrder;

import java.util.HashMap;
import java.util.List;

public interface CheckOrderService extends IService<CheckOrder> {

    List<HashMap<String,String>> invokeSql(String sqlString);

    List<CheckOrder> listCheckOrders();
}
