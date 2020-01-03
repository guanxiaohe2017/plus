package com.mybatis.plus.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mybatis.plus.entity.order.CheckOrder;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>描述：阜外盘点单表Mapper接口</p>
 * <p>公司：浙江瑞华康源科技有限公司</p>
 * <p>版权：rivamed-2019</p>
 * @author 官昌洪
 * @since 2019-10-23
 */
public interface CheckOrderMapper extends BaseMapper<CheckOrder> {

    List<HashMap<String,String>> invokeSql(@Param("sqlString") String sqlString);
 }
