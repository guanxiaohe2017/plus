package com.mybatis.plus.dto;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatis.plus.entity.order.CheckOrder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>描述：阜外盘点单表数据传输对象 </p>
 * <p>公司：浙江瑞华康源科技有限公司</p>
 * <p>版权：rivamed-2019</p>
 * @author 官昌洪
 * @since 2019-10-18
 */
@Getter
@Setter
public class CheckOrderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private CheckOrder checkOrder;
	private List<CheckOrder> checkOrders;
	private Page<CheckOrder> checkOrderPage;


	 private String thingId;

	 private String thingName;

	 private String deviceName;

	 private String deviceId;

	 private String sthName;

	 private String sthId;
	private List<String> sthIds;

	private String orderNo;

	private String term;

	/** 开始时间 ***/
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date startTime;
	/** 结束时间 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date endTime;

}
