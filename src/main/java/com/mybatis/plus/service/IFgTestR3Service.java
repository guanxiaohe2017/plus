package com.mybatis.plus.service;

import com.mybatis.plus.entity.FgTestR3;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 法规表 服务类
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
public interface IFgTestR3Service extends IService<FgTestR3> {

    void formatContent();

    void formatContentContainsWd();

    void moveToWd();

    void fixFg();

    void changeTimeliness();

    void addType();

    void deleteSHWD();

    void addDimension(String type, String webGuid);

    void removeRepeatItems();

    void fixFg2();

    void handleNumbers();

    void fixTitles();

    void removeHref(String webGuid);

    void reAddFj();
}
