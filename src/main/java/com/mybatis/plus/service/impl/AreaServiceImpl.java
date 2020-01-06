package com.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mybatis.plus.entity.Area;
import com.mybatis.plus.entity.FgTestR3;
import com.mybatis.plus.entity.WdTestR3;
import com.mybatis.plus.mapper.AreaMapper;
import com.mybatis.plus.service.IAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.service.IFgTestR3Service;
import com.mybatis.plus.service.IWdTestR3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 地区表 服务实现类
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {

    @Autowired
    IWdTestR3Service wdTestR3Service;

    @Autowired
    IFgTestR3Service fgTestR3Service;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void wdAddAreaId() {
        List<WdTestR3> wdTestR3s = wdTestR3Service.list();
        Map<String, String> stringMap = this.list().stream().filter(area -> null != area.getAreaName())
                .collect(Collectors
                        .toMap(o -> o.getAreaName(), o -> o.getAreaId(), (key1, key2) -> key2));
        Set<String> keySet = stringMap.keySet();
        for (WdTestR3 wdTestR3 : wdTestR3s) {
            String requestObject = wdTestR3.getRequestObject();
//            requestObject.substring(0,requestObject.length()-2);   //截掉"税务局"
            if (StringUtils.isNotEmpty(requestObject)) {
                for (String s : keySet) {
                    if (requestObject.contains(s)) {
                        wdTestR3.setAreaId(stringMap.get(s));
                        break;
                    }
                }
            }
        }
        wdTestR3Service.updateBatchById(wdTestR3s);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void fgAddAreaId() {
        List<FgTestR3> fgTestR3s = fgTestR3Service.list();
        Map<String, String> stringMap = this.list().stream().filter(area -> null != area.getAreaName())
                .collect(Collectors
                        .toMap(o -> o.getAreaName(), o -> o.getAreaId(), (key1, key2) -> key2));
        Set<String> keySet = stringMap.keySet();
        for (FgTestR3 fgTestR3 : fgTestR3s) {
            String units = fgTestR3.getUnits();
//            requestObject.substring(0,requestObject.length()-2);   //截掉"税务局"
            if (StringUtils.isNotEmpty(units)) {
                for (String s : keySet) {
                    if (units.contains(s)) {
                        fgTestR3.setAreaId(stringMap.get(s));
                        break;
                    }
                }
            }
        }
        fgTestR3Service.updateBatchById(fgTestR3s);
    }
}
