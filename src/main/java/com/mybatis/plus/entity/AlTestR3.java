package com.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 案例表
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Txj_al_test_r3")
public class AlTestR3 implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(value = "autoid", type = IdType.AUTO)
    private Long autoid;

    /**
     * id
     */
    private String guids;

    /**
     * 名称
     */
    private String titles;

    /**
     * 文号
     */
    private String numbers;

    /**
     * 时效性
     */
    private String timeliness;

    /**
     * Keys
     */
    private String keys;

    /**
     * 发文单位
     */
    private String units;

    /**
     * 发文年份
     */
    private String years;

    /**
     * 描述
     */
    private String contents;

    /**
     * 税种
     */
    private String stypes;

    /**
     * 适用地区
     */
    @TableField("areaId")
    private String areaId;

    /**
     * 相关行业
     */
    private String economics;

    /**
     * 整理时间
     */
    private String adddate;

    /**
     * 是否显示
     */
    private Integer isshow;

    /**
     * 来源
     */
    private Integer sources;

    /**
     * 热度
     */
    private Integer clicks;

    /**
     * 程序法
     */
    private String prolaws;

    /**
     * 摘要
     */
    private String zaiyao;

    /**
     * 来源网站名称
     */
    @TableField("sourceWebName")
    private String sourceWebName;

    /**
     * 采集地址
     */
    @TableField("sourceURL")
    private String sourceURL;

    /**
     * 下载后附件名字
     */
    @TableField("attachmentesName")
    private String attachmentesName;

    /**
     * 下载后附件地址
     */
    @TableField("attachmentesUrl")
    private String attachmentesUrl;

    /**
     * 是否进行附件采集
     */
    @TableField("iscollectionFJ")
    private String iscollectionFJ;

    /**
     * 附件采集时间
     */
    @TableField("cfjCollectionDate")
    private LocalDateTime cfjCollectionDate;

    /**
     * 采集附件名字
     */
    @TableField("collectFjName")
    private String collectFjName;

    /**
     * 采集附件地址
     */
    @TableField("collectFjUrl")
    private String collectFjUrl;

    /**
     * 罪行
     */
    @TableField("crimeTypeDesc")
    private String crimeTypeDesc;

    /**
     * 关联文章采集网站id
     */
    @TableField("webGuid")
    private String webGuid;


}
