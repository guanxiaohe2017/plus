package com.mybatis.plus.service.impl;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.entity.Dict;
import com.mybatis.plus.entity.FgTestR3;
import com.mybatis.plus.entity.WdTestR3;
import com.mybatis.plus.mapper.FgTestR3Mapper;
import com.mybatis.plus.service.IDictService;
import com.mybatis.plus.service.IFgTestR3Service;
import com.mybatis.plus.service.IWdTestR3Service;
import com.mybatis.plus.utils.CommonConstraint;
import com.mybatis.plus.utils.TypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 法规表 服务实现类
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Service
public class FgTestR3ServiceImpl extends ServiceImpl<FgTestR3Mapper, FgTestR3> implements IFgTestR3Service {

    @Autowired
    private IFgTestR3Service iFgTestR3Service;

    @Autowired
    private IWdTestR3Service wdTestR3Service;

    @Autowired
    private IDictService dictService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void formatContent() {
        List<FgTestR3> list = iFgTestR3Service.list();
        List<FgTestR3> saveList = new ArrayList<>();
        for (FgTestR3 fgTestR3 : list) {
            String content = fgTestR3.getContents();
            if (StringUtils.isNotEmpty(content)) {
                fgTestR3.setContents(content.replace("　　", "\n\n"));
            }
            saveList.add(fgTestR3);
        }
        iFgTestR3Service.updateBatchById(saveList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void formatContentContainsWd() {
        QueryWrapper<FgTestR3> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("clicks",3);
        List<FgTestR3> list = iFgTestR3Service.list(queryWrapper);
        List<FgTestR3> saveList = new ArrayList<>();
        for (FgTestR3 fgTestR3 : list) {
            String content = fgTestR3.getContents();
            if (StringUtils.isNotEmpty(content)) {
                fgTestR3.setContents(content.replace("？", "？\n"));
            }
            saveList.add(fgTestR3);
        }
        iFgTestR3Service.updateBatchById(saveList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void moveToWd() {
        List<FgTestR3> fgTestR3s = iFgTestR3Service
                .list((new QueryWrapper<FgTestR3>()).eq("clicks", "3"));

        List<WdTestR3> wdTestR3s = new ArrayList<>();
        for (FgTestR3 fgTestR3 : fgTestR3s) {
            WdTestR3 wdTestR3 = new WdTestR3();
            wdTestR3.setGuids(fgTestR3.getGuids());
            wdTestR3.setTitles(fgTestR3.getTitles());
            wdTestR3.setResponseTime(DateUtil.parseDate(fgTestR3.getYears()));
            wdTestR3.setContents(fgTestR3.getContents());
            wdTestR3.setSourceURL(fgTestR3.getSourceUrl());
            wdTestR3.setWebGuid(fgTestR3.getWebGuid());
            wdTestR3s.add(wdTestR3);
            wdTestR3Service.save(wdTestR3);
        }
//        wdTestR3Service.saveBatch(wdTestR3s);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void fixFg() {
        QueryWrapper<FgTestR3> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("webGuid","112");
        queryWrapper.isNotNull("collectFjName");
        queryWrapper.ne("collectFjName","");
        List<FgTestR3> list = iFgTestR3Service.list(queryWrapper);

        for (FgTestR3 fgTestR3 : list) {
            fgTestR3.setAttachmentesUrl(fgTestR3.getCollectFjName());
            fgTestR3.setFjCollectionDate(LocalDateTime.now());
            fgTestR3.setIscollectionFJ("1");
            String name = fgTestR3.getCollectFjName();
            StringBuilder regex = new StringBuilder();
//            if (name.contains("103")) {
//                regex.append("\\");
//                regex.append("Files");
//                regex.append("\\");
//                regex.append("103");
//                regex.append("\\");
//            } else if (name.contains("105")) {
//                regex.append("\\");
//                regex.append("Files");
//                regex.append("\\");
//                regex.append("105");
//                regex.append("\\");
//            } else if (name.contains("106")) {
//                regex.append("\\");
//                regex.append("Files");
//                regex.append("\\");
//                regex.append("106");
//                regex.append("\\");
//            } else if (name.contains("107")) {
//                regex.append("\\");
//                regex.append("Files");
//                regex.append("\\");
//                regex.append("107");
//                regex.append("\\");
//            } else if (name.contains("108")) {
//                regex.append("\\");
//                regex.append("F");
//                regex.append("iles");
//                regex.append("\\");
//                regex.append("108");
//                regex.append("\\");
//            }

            if (name.contains("112")) {
                regex.append("\\");
                regex.append("Files");
                regex.append("\\");
                regex.append("112");
                regex.append("\\");
            }

            fgTestR3.setAttachmentesName(name.replace(regex.toString(),""));
        }

        iFgTestR3Service.updateBatchById(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeTimeliness() {
        QueryWrapper<FgTestR3> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("webGuid","103");
        queryWrapper.isNull("timeliness");
        List<FgTestR3> list = iFgTestR3Service.list(queryWrapper);

        for (FgTestR3 fgTestR3 : list) {
            String content = fgTestR3.getContents();
            if (StringUtils.isNotEmpty(content)) {
                if (content.contains("失效") || content.contains("修订") || content.contains("废止")) {
                    continue;
                } else {
                    fgTestR3.setTimeliness("全文有效");
                }
            }
        }
        iFgTestR3Service.updateBatchById(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addType() {
        QueryWrapper<FgTestR3> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("webGuid","103");
        queryWrapper.isNull("stypes");
        List<FgTestR3> list = iFgTestR3Service.list(queryWrapper);

        for (FgTestR3 fgTestR3 : list) {
            StringBuilder id = new StringBuilder();
            String title = fgTestR3.getTitles();
            if (StringUtils.isNotEmpty(title)) {
                TypeEnum[] values = TypeEnum.values();
                for (TypeEnum value : values) {
                    if (!"其他".equals(value.getName())) {
                        if (!"税收优惠".equals(value.getName())) {
                            if (title.contains(value.getName())) {
                                addId(id, value);
                            }
                        }
                    }
                }

                if (title.contains("优惠") || title.contains("减免")) {
                    addId(id, TypeEnum.FREET);
                }

                if (id.length() < 2) {
                    addId(id, TypeEnum.OTHER);
                }

                fgTestR3.setStypes(id.toString());
            }
        }
        iFgTestR3Service.updateBatchById(list);
    }


    private void addId(StringBuilder id, TypeEnum typeEnum) {
        if (id.length() > 2) {
            id.append("," + typeEnum.getId());
        } else {
            id.append(typeEnum.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSHWD() {
        QueryWrapper<FgTestR3> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("webGuid","103");
        List<FgTestR3> fgTestR3s = iFgTestR3Service.list(queryWrapper);

        List<WdTestR3> wdTestR3s = wdTestR3Service.list((new QueryWrapper<WdTestR3>()).eq("webGuid", "103"));
        List<String> titleList = wdTestR3s.stream()
                .filter(wdTestR3 -> null != wdTestR3.getTitles())
                .map(wdTestR3 -> wdTestR3.getTitles()).collect(Collectors.toList());

        List<FgTestR3> deleteFg = new ArrayList<>();

        for (FgTestR3 fgTestR3 : fgTestR3s) {
            if (titleList.contains(fgTestR3.getTitles())) {
                deleteFg.add(fgTestR3);
            }
        }

        List<Long> longs = deleteFg.stream().map(fgTestR3 -> fgTestR3.getAutoid()).collect(Collectors.toList());
        iFgTestR3Service.removeByIds(longs);
    }

    @Override
    public void addDimension(String type, String webGuid) {
        String flagStr = "无";
        List<Dict> preDicts = dictService.list((new QueryWrapper<Dict>()).eq("dictType", type).orderByDesc("priority"));
        List<FgTestR3> fgTestR3s = iFgTestR3Service.list((new QueryWrapper<FgTestR3>()).eq("webGuid", webGuid));

        List<Dict> optDicts = preDicts.stream().filter(dict -> !flagStr.equals(dict.getDictDesc())).collect(Collectors.toList());
        Dict defaultDict = preDicts.stream().filter(dict -> flagStr.equals(dict.getDictDesc())).collect(Collectors.toList()).get(0);

        if (Dict.TIMELINESS.equals(type)) {
            for (FgTestR3 fgTestR3 : fgTestR3s) {
                String timeliness = null;
                for (Dict optDict : optDicts) {
                    if (StringUtils.isNotEmpty(timeliness)) {
                        break;
                    }
                    String[] split = optDict.getDictDesc().split(CommonConstraint.REGEX_COMMA);
                    for (String desc : split) {
                        if (fgTestR3.getContents().contains(desc)) {
                            timeliness = optDict.getDictValue();
                            break;
                        }
                    }
                }

                if (StringUtils.isNotEmpty(timeliness)) {
                    fgTestR3.setTimeliness(timeliness);
                } else {
                    fgTestR3.setTimeliness(defaultDict.getDictValue());
                }
            }
        } else if (Dict.INDUSTRY.equals(type)) {
            for (FgTestR3 fgTestR3 : fgTestR3s) {
                StringBuilder industry = new StringBuilder();
                handleMutiDimension(optDicts, industry, fgTestR3);

                if (StringUtils.isNotEmpty(industry.toString())) {
                    fgTestR3.setEconomics(industry.toString());
                } else {
                    fgTestR3.setEconomics(defaultDict.getDictValue());
                }
            }
        } else if (Dict.TAX_TYPE.equals(type)) {
            for (FgTestR3 fgTestR3 : fgTestR3s) {
                StringBuilder taxType = new StringBuilder();
                handleMutiDimension(optDicts, taxType, fgTestR3);

                if (StringUtils.isNotEmpty(taxType.toString())) {
                    fgTestR3.setStypes(taxType.toString());
                } else {
                    fgTestR3.setStypes(defaultDict.getDictValue());
                }
            }
        } else {
            throw new RuntimeException("参数错误");
        }

        iFgTestR3Service.updateBatchById(fgTestR3s);
    }

    private void handleMutiDimension(List<Dict> optDicts, StringBuilder dimensionType, FgTestR3 fgTestR3) {
        for (Dict optDict : optDicts) {
            String[] split = optDict.getDictDesc().split(CommonConstraint.REGEX_COMMA);
            for (String desc : split) {
                if (fgTestR3.getContents().contains(desc)) {
                    if (dimensionType.length() > 0) {
                        dimensionType.append(CommonConstraint.REGEX_COMMA + optDict.getDictValue());
                    } else {
                        dimensionType.append(optDict.getDictValue());
                    }
                    break;
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeRepeatItems() {
        List<Long> removeList = new ArrayList<>();
        List<FgTestR3> baseList = iFgTestR3Service
                .list((new QueryWrapper<FgTestR3>()).select("autoid","titles","numbers")
                        .eq("webGuid","1"));
        List<String> baseStrs = baseList.stream().filter(e -> StringUtils
                .isNotEmpty(e.getTitles()) && StringUtils.isNotEmpty(e.getNumbers()))
                .map(e -> e.getTitles().trim() + e.getNumbers().trim())
                .collect(Collectors.toList());

        List<FgTestR3> list = iFgTestR3Service
                .list((new QueryWrapper<FgTestR3>())
                        .select("autoid","titles","numbers")
                        .ne("webGuid","1"));
        for (FgTestR3 fgTestR3 : list) {
            if (StringUtils.isEmpty(fgTestR3.getNumbers())
                    || StringUtils.isEmpty(fgTestR3.getTitles())) {
                continue;
            }
            if (baseStrs.contains(fgTestR3.getTitles().trim()+fgTestR3.getNumbers().trim())) {
                removeList.add(fgTestR3.getAutoid());
            }
        }
        int size = removeList.size();
        int fromIndex = 0;
        int toIndex = 2000;
        while (toIndex < size) {
            optDelete(removeList, fromIndex, toIndex);
            fromIndex = toIndex;
            toIndex = toIndex + 2000;
        }

        if (fromIndex < size) {
            toIndex = size;
            optDelete(removeList, fromIndex, toIndex);
        }
    }

    private void optDelete(List<Long> removeList, int fromIndex, int toIndex) {
        List<Long> optList = removeList.subList(fromIndex, toIndex);
        iFgTestR3Service.removeByIds(optList);
    }

    //    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeRepeatItems2() {
        List<Long> removeList = new ArrayList<>();
        List<FgTestR3> list = iFgTestR3Service
                .list((new QueryWrapper<FgTestR3>()).select("autoid","titles","numbers"));
        List<String> numbers = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (FgTestR3 fgTestR3 : list) {
            if (StringUtils.isEmpty(fgTestR3.getNumbers())
                    || StringUtils.isEmpty(fgTestR3.getTitles())) {
                continue;
            }
            if (numbers.contains(fgTestR3.getNumbers().trim())
                    && titles.contains(fgTestR3.getTitles().trim())) {
                removeList.add(fgTestR3.getAutoid());
            } else {
                numbers.add(fgTestR3.getNumbers());
                titles.add(fgTestR3.getTitles());
            }
        }
        int size = removeList.size();

//        iFgTestR3Service.removeByIds(removeList);

    }
}
