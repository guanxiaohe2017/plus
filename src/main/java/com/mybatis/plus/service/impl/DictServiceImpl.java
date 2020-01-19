package com.mybatis.plus.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.mybatis.plus.entity.Dict;
import com.mybatis.plus.mapper.DictMapper;
import com.mybatis.plus.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gch
 * @since 2020-01-15
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

    @Override
    public void importExcel() {
        ExcelReader reader = ExcelUtil.getReader("C:/Users/TXJS/Documents/WeChat Files/g8947014/FileStorage/File/2020-01/industy_type.xlsx");
        List<Dict> dicts = reader.readAll(Dict.class);
        for (Dict dict : dicts) {
            dict.setDictId(UUID.fastUUID().toString());
            save(dict);
        }
    }
}
