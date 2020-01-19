package com.mybatis.plus.service;

import com.mybatis.plus.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gch
 * @since 2020-01-15
 */
public interface IDictService extends IService<Dict> {

    void importExcel();
}
