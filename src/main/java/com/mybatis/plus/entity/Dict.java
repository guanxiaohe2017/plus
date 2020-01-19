package com.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gch
 * @since 2020-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Txj_dict")
public class Dict implements Serializable {

private static final long serialVersionUID=1L;

    public static final String TIMELINESS = "timeliness";
    public static final String INDUSTRY = "industry";
    public static final String TAX_TYPE = "taxType";

    /**
     * 主键
     */
    @TableId(value = "AutoId", type = IdType.AUTO)
    private Long autoId;

    /**
     * 唯一id
     */
    @TableField("dictId")
    private String dictId;

    /**
     * 字典描述
     */
    @TableField("dictDesc")
    private String dictDesc;

    /**
     * 字典名称
     */
    @TableField("dictName")
    private String dictName;

    /**
     * 字典值
     */
    @TableField("dictValue")
    private String dictValue;

    /**
     * 字典类型
     */
    @TableField("dictType")
    private String dictType;

    /**
     * 类型名称
     */
    @TableField("typeName")
    private String typeName;

    /**
     * 优先级（数值越低，优先级越高）
     */
    @TableField("priority")
    private Integer priority;


}
