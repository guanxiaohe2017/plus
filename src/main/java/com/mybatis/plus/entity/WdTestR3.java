package com.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 问答表
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Txj_wd_test_r3")
public class WdTestR3 implements Serializable {

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
     * 提问
     */
    private String titles;

    /**
     * Keys
     */
    private String keys;

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
     * 整理时间
     */
    private String adddate;

    /**
     * 来源
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
     * 是否进行附件采集(0,否，1是）
     */
    @TableField("iscollectionFJ")
    private String iscollectionFJ;

    /**
     * 附件采集时间
     */
    @TableField("cfjCollectionDate")
    private Date cfjCollectionDate;

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
     * 关联文章采集网站id
     */
    @TableField("webGuid")
    private String webGuid;

    /**
     * 咨询对象
     */
    @TableField("requestObject")
    private String requestObject;

    /**
     * 咨询内容
     */
    @TableField("requestContent")
    private String requestContent;

    /**
     * 咨询机构
     */
    @TableField("responseOrgan")
    private String responseOrgan;

    /**
     * 答复时间
     */
    @TableField("responseTime")
    private Date responseTime;

    /**
     * 答复内容
     */
    @TableField("responseContent")
    private String responseContent;


}
