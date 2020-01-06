package com.mybatis.plus.service.impl;

import com.mybatis.plus.entity.SomeType;
import com.mybatis.plus.mapper.SomeTypeMapper;
import com.mybatis.plus.service.ISomeTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 综合类型表 服务实现类
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Service
public class SomeTypeServiceImpl extends ServiceImpl<SomeTypeMapper, SomeType> implements ISomeTypeService {

}
