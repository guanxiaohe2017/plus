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
 * 
 * </p>
 *
 * @author gch
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Txj_SourceWeb")
public class SourceWeb implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 自增id
     */
    @TableId(value = "autoid", type = IdType.AUTO)
    private Integer autoid;

    /**
     * guid
     */
    private String guids;

    /**
     * 序号
     */
    @TableField("webOrder")
    private Integer webOrder;

    /**
     * 网站名称
     */
    @TableField("webName")
    private String webName;

    /**
     * 网站地址
     */
    @TableField("webUrl")
    private String webUrl;

    /**
     * 网站描述
     */
    @TableField("webIntro")
    private String webIntro;

    /**
     * 文章类型
0 通用
1 财税法规
2 财税问答
3 财税案例
……

     */
    @TableField("webType")
    private Integer webType;

    /**
     * 目标数据量
     */
    @TableField("totalNum")
    private Integer totalNum;

    /**
     * 已采集量
     */
    @TableField("collectNum")
    private Integer collectNum;

    /**
     * 最后采集更新日期
     */
    @TableField("collectDatetime")
    private LocalDateTime collectDatetime;

    /**
     * 备用字段
     */
    @TableField("webMarks")
    private String webMarks;


}
