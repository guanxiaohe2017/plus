package com.mybatis.plus.entity.consumables;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>描述：耗材流水实体类</p>
 * <p>公司：浙江瑞华康源科技有限公司</p>
 * <p>版权：rivamed-2019</p>
 * @author Renlei
 * @since 2019-08-13
 */
@Data
@Accessors(chain = true)
@JsonInclude(Include.NON_EMPTY)
@TableName("t_fhvc_inventory_journal")
public class FhvcInventoryJournal {

	private static final long serialVersionUID=1L;



    /**
     * 返还
     */
    public static final String STATUS_RETURN = "37";

    /**
     * 库存减少
     */
    public static final Integer STOCK_REDUCE = -1;
    /**
     * 库存增加
     */
    public static final Integer STOCK_ADD = 1;

    /**
     * 库存不变
     */
    public static final Integer STOCK_UNCHANGE = 0;



    /**
     * 主键
     */
    @TableId(value = "journal_id", type = IdType.UUID)
    private String journalId;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 耗材epc
     */
    @TableField("epc")
    private String epc;

    /**
     * t_fhvc_inventory主键Id
     */
    @TableField("inventory_id")
    private String inventoryId;

    /**
     * 耗材字典主键
     */
    @TableField("cst_id")
    private String cstId;

    /**
     * 有效期
     */
    @TableField("expiry_date")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date expiryDate;

    /**
     * 设备部件名称
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 设备部件Id
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 设备Id
     */
    @TableField("thing_id")
    private String thingId;

    /**
     * 设备name
     */
    @TableField("thing_name")
    private String thingName;

    @TableField("sth_id")
    private String sthId;

    @TableField("sth_name")
    private String sthName;

    /**
     * 操作人ID
     */
    @TableField("creator")
    private String creator;

    /**
     * 操作人
     */
    @TableField("creator_id")
    private String creatorId;

    /**
     * 患者姓名
     */
    @TableField("patient_name")
    private String patientName;

    /**
     * 患者ID
     */
    @TableField("patient_id")
    private String patientId;

    /**
     * 患者就诊Id
     */
    @TableField(value = "medical_id")
    private String medicalId;


    /**
     * 备注（借出备注）
     */
    @TableField("remark")
    private String remark;

    /**
     *  常用名
     */
    @TableField("usual_name")
    private String usualName;

    /**
     * 手术间
     */
    @TableField("room_name")
    private String roomName;

    /**
     * 耗材领用人姓名ID
     */
    @TableField("take_id")
    private String takeId;

    /**
     * 耗材领用人姓名
     */
    @TableField("take_name")
    private String takeName;

    @TableField(exist = false)
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;

    /**
     * 耗材数量
     */
    @TableField("cst_num")
    private Integer cstNum;

    /**
     * 本次补录数量
     */
    @TableField("entry_num")
    private Integer entryNum;

    //状态名称
    @TableField(exist = false)
    private String statusName;

    //设备名称
    @TableField(exist = false)
    private String cstName;

    //类别
    @TableField(exist = false)
    private String valueType;

    //型号规格
    @TableField(exist = false)
    private String cstSpec;

    // 双签操作人
    @TableField("double_checker")
    private String doubleChecker;
    
  // 双签操作人id
    @TableField("double_checker_id")
    private String doubleCheckerId;
   
    // 库存变更前数量
    @TableField("before_num")
    private Integer beforeNum;
    
    // 库存变更后数量
    @TableField("after_num")
    private Integer afterNum;

    @TableField("batch_no")
    private String batchNo;

    @TableField("his_patient_id")
    private String hisPatientId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
