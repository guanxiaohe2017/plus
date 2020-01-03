package com.mybatis.plus.entity.order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>描述：阜外盘点单表实体类</p>
 * <p>公司：浙江瑞华康源科技有限公司</p>
 * <p>版权：rivamed-2019</p>
 * @author 官昌洪
 * @since 2019-10-23
 */
@Data
@Accessors(chain = true)
@JsonInclude(Include.NON_EMPTY)
@TableName("t_fhvc_check_order")
public class CheckOrder {

	private static final long serialVersionUID=1L;

    /**
     * 盘点单表主键Id
     */
    @TableId(value = "check_order_id", type = IdType.UUID)
    private String checkOrderId;

    /**
     * 设备表Id
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 柜子名称
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 库房Id
     */
    @TableField("sth_id")
    private String sthId;

    /**
     * 库房名称
     */
    @TableField("sth_name")
    private String sthName;

    /**
     * 盘点单号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 创建人（盘点人）
     */
    @TableField("creator")
    private String creator;

    /**
     * 状态：0-未完成；1-盘点完成；2-盘点中
     */
    @TableField("status")
    private String status;


}
