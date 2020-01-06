package com.mybatis.plus.service;

import com.mybatis.plus.entity.Area;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
public interface IAreaService extends IService<Area> {

    void wdAddAreaId();

    void fgAddAreaId();
}
