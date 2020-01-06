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
 * 综合类型表
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_Some_Type")
public class SomeType implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键，自增
     */
    @TableId(value = "autoid", type = IdType.AUTO)
    private Integer autoid;

    /**
     * GUID
     */
    @TableField("someType_id")
    private String sometypeId;

    /**
     * 父级ID
     */
    @TableField("someFtype_id")
    private String someftypeId;

    /**
     * 系统
     */
    private String forSystem;

    /**
     * 名称
     */
    @TableField("someType_name")
    private String sometypeName;

    /**
     * 备注
     */
    @TableField("someFtype_mark")
    private String someftypeMark;

    /**
     * 操作时间
     */
    @TableField("someType_Date")
    private LocalDateTime sometypeDate;

    /**
     * 操作人
     */
    private String userid;

    /**
     * 类型（1.证书）
     */
    @TableField("someType_type")
    private String sometypeType;

    /**
     * 是否删除
     */
    private Integer isdel;

    /**
     * 排序
     */
    @TableField("SortId")
    private Integer SortId;

    @TableField("ShortName")
    private String ShortName;

    @TableField("Disable")
    private Integer Disable;

    @TableField("Selected")
    private Integer Selected;


}
