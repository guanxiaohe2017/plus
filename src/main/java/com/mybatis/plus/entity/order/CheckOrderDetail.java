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
 * <p>描述：阜外盘点单明细表实体类</p>
 * <p>公司：浙江瑞华康源科技有限公司</p>
 * <p>版权：rivamed-2019</p>
 * @author 官昌洪
 * @since 2019-10-23
 */
@Data
@Accessors(chain = true)
@JsonInclude(Include.NON_EMPTY)
@TableName("t_fhvc_check_order_detail")
public class CheckOrderDetail {

	private static final long serialVersionUID=1L;

    /**
     * 明细表主键Id
     */
    @TableId(value = "check_order_detail_id", type = IdType.UUID)
    private String checkOrderDetailId;

    /**
     * 盘点单Id
     */
    @TableField("check_order_id")
    private String checkOrderId;

    /**
     * 耗材信息表id
     */
    @TableField("cst_id")
    private String cstId;

    /**
     * 库存表Id
     */
    @TableField("inventory_id")
    private String inventoryId;

    /**
     * 账面数量
     */
    @TableField("bill_num")
    private Integer billNum;

    /**
     * 已盘数量
     */
    @TableField("check_num")
    private Integer checkNum;

    /**
     * 状态：0-盘亏；1-盘盈；2-正常
     */
    @TableField("status")
    private String status;


}
