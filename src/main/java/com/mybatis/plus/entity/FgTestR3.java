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
 * 法规表
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Txj_fg_test_r3")
public class FgTestR3 implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "autoid", type = IdType.AUTO)
    private Long autoid;

    /**
     * 内容ID
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
     * 关键字
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
     * 正文内容
     */
    private String contents;

    /**
     * 税种
     */
    private String stypes;

    /**
     * 实用地区
     */
    @TableField("areaId")
    private String areaId;

    /**
     * 相关行业
     */
    private String economics;

    /**
     * 添加整理时间
     */
    private LocalDateTime adddate;

    /**
     * 是否显示
     */
    private Integer isshow;

    /**
     * 来源（码表见文档）
     */
    private Integer sources;

    /**
     * 热度
     */
    private Integer clicks;

    /**
     * 来源网站名称
     */
    @TableField("sourceWebName")
    private String sourceWebName;

    /**
     * 采集下载地址
     */
    @TableField("sourceUrl")
    private String sourceUrl;

    /**
     * 附件下载后名字逗号分隔
     */
    @TableField("attachmentesName")
    private String attachmentesName;

    /**
     * 附件下载后路径逗号分隔
     */
    @TableField("attachmentesUrl")
    private String attachmentesUrl;

    /**
     * 是否已采集附件：
null： 暂未处理
0：文章无附件
1：文章有附件且已采集
2：文章有附件但未采集
     */
    @TableField("iscollectionFJ")
    private String iscollectionFJ;

    /**
     * 附件采集时间
     */
    @TableField("fjCollectionDate")
    private LocalDateTime fjCollectionDate;

    /**
     * 采集到的附件名称，多个附件以逗号分隔
     */
    @TableField("collectFjName")
    private String collectFjName;

    /**
     * 采集到的附件地址(可供下载的原始地址)，多个附件以逗号分隔
     */
    @TableField("collectFjUrl")
    private String collectFjUrl;

    /**
     * 关联文章采集网站id
     */
    @TableField("webGuid")
    private String webGuid;


}
