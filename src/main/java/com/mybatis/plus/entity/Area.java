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
 * 地区表
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_Area")
public class Area implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键自增
     */
    @TableId(value = "AutoId", type = IdType.AUTO)
    private Integer AutoId;

    /**
     * 地区Id
     */
    @TableField("AreaId")
    private String AreaId;

    /**
     * 地区名称
     */
    @TableField("AreaName")
    private String AreaName;

    /**
     * 父级地区（内联，根为空字符串，其它地区则为父级地区ID）
     */
    @TableField("ParentId")
    private String ParentId;

    /**
     * 是否删除（1（true）已删除，0（false）未删除）
     */
    @TableField("AreaIsDel")
    private Boolean AreaIsDel;

    /**
     * 行政区域代码
     */
    @TableField("AreaGovCode")
    private Long AreaGovCode;

    /**
     * 父级行政区域代码
     */
    @TableField("AreaParentGovCode")
    private Long AreaParentGovCode;

    /**
     * 行政区域等级（1省级，2县市级，3乡镇级）
     */
    @TableField("AreaLevel")
    private Integer AreaLevel;

    /**
     * 帐号代码
     */
    @TableField("AreaCode")
    private String AreaCode;

    @TableField("AreaSort")
    private Integer AreaSort;

    /**
     * 创建时间
     */
    @TableField("AddTime")
    private LocalDateTime AddTime;

    /**
     * 数据来源
     */
    @TableField("DataSource")
    private String DataSource;

    /**
     * 备用字段
     */
    @TableField("AreaField")
    private String AreaField;


}
