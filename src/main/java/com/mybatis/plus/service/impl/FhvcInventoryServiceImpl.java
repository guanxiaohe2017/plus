package com.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.entity.consumables.FhvcInventory;
import com.mybatis.plus.entity.order.CheckOrder;
import com.mybatis.plus.mapper.consumables.FhvcInventoryMapper;
import com.mybatis.plus.mapper.order.CheckOrderMapper;
import com.mybatis.plus.service.CheckOrderService;
import com.mybatis.plus.service.FhvcInventoryService;
import org.springframework.stereotype.Service;

@Service
public class FhvcInventoryServiceImpl extends ServiceImpl<FhvcInventoryMapper, FhvcInventory> implements FhvcInventoryService {

}
