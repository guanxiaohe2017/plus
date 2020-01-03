package com.mybatis.plus.entity.consumables;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>描述：阜外库房耗材清单实体类</p>
 * <p>公司：浙江瑞华康源科技有限公司</p>
 * <p>版权：rivamed-2019</p>
 *
 * @author Renlei
 * @since 2019-08-13
 */
@Data
@Accessors(chain = true)
@JsonInclude(Include.NON_EMPTY)
@TableName("t_fhvc_inventory")
public class FhvcInventory {

    private static final long serialVersionUID = 1L;

    /**
     * 一级库出库二级库待入库
     */
    public static final String READYIN_STORAGE = "-1";
    /**
     * 一级库供应商入库
     */
    public static final String STATUS_ONEIN = "0";

    /**
     * 状态： 二级库入库
     */
    public static final String STATUS_TWOIN = "2";


    /**
     * 未领用
     */
    public static final String STATUS_NO_TAKE = "0";

    /**
     * 领用
     */
    public static final String STATUS_TAKE = "3";

    /***
     * 移入状态
     */
    public static final String MOVE_IN = "10";

    /**
     * 调拨入库
     */
    public static final String ALLOT_IN = "13";

    /**
     * 状态： 医嘱领用
     */
    public static final String STATUS_ORDER_TAKE = "33";

    /**
     * 状态： 移除
     */
    public static final String STATUS_REMOVE = "14";

    /**
     * 状态： 急救领用
     */
    public static final String STATUS_AID_TAKE = "34";

    /**
     * 状态： 自管领用
     */
    public static final String STATUS_OWN_TAKE = "35";

    /**
     * 状态： 补录领用
     */
    public static final String STATUS_SUPP_TAKE = "36";

    /**
     * 最终使用
     */
    public static final String STATUS_FINAL_USE = "18";

    /**
     * 维修
     */
    public static final String STATUS_FIX = "26";

    /**
     * 患者借出
     */
    public static final String STATUS_PATIENT_LEND = "27";

    /**
     * 病区借出
     */
    public static final String STATUS_DEPT_LEND = "28";

    /**
     * 送消暂存
     */
    public static final String SEND_DISINFECT_IN = "29";

    /**
     * 送消领取
     */
    public static final String SEND_DISINFECT_OUT = "30";

    /**
     * 禁止操作
     */
    public static final String DISABLE_OPERATION = "70";

    /**
     * 盘亏
     */
    public static final String STATUS_LITTLE = "38";

    /**
     * 盘盈
     */
    public static final String STATUS_MORE = "39";

    /**
     * 盘盈入库
     */
    public static final String STATUS_MORE_IN = "40";

    /**
     * 盘亏出库
     */
    public static final String STATUS_LITTLE_OUT = "41";

    /**
     * 耗材使用记录
     */
    public static final String USE_RECORDE = "0";

    /**
     * 耗材退回记录
     */
    public static final String BACK_RECORDE = "1";


    /**
     * 库存主键
     */
    @TableId(value = "inventory_id", type = IdType.UUID)
    private String inventoryId;

    /**
     * 库房物资设置ID
     */
    @TableField("sth_cst_id")
    private String sthCstId;

    /**
     * 库房编码
     */
    @TableField("sth_id")
    private String sthId;

    @TableField("target_sth_id")
    private String targetSthId;

    /**
     * 耗材字典表主键
     */
    @TableField("cst_id")
    private String cstId;

    /**
     * 耗材关联患者名称
     */
    @TableField(value = "patient_name", strategy = FieldStrategy.IGNORED, el = "patientName, jdbcType=VARCHAR")
    private String patientName;

    /**
     * 耗材关联患者Id
     */
    @TableField(value = "patient_id", strategy = FieldStrategy.IGNORED, el = "patientId, jdbcType=VARCHAR")
    private String patientId;

    /**
     * 患者就诊Id
     */
    @TableField(value = "medical_id", strategy = FieldStrategy.IGNORED, el = "medicalId, jdbcType=VARCHAR")
    private String medicalId;

    /**
     * 供应商ID
     */
    @TableField("vendor_id")
    private String vendorId;

    /**
     * EPC
     */
    @TableField("epc")
    private String epc;

    /**
     * 设备唯一标识,通过PC端、手持终端入库
     */
    @TableField("device_id")
    private String deviceId;

    /**
     * 物联网节点Id
     */
    @TableField("thing_id")
    private String thingId;

    /**
     * 患者唯一标识
     */
    @TableField("his_patient_id")
    private String hisPatientId;

    /**
     * thing名称
     */
    @TableField("thing_name")
    private String thingName;

    /**
     * 库房名称
     */
    @TableField("sth_name")
    private String sthName;

    /**
     * 柜号
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 科室ID
     */
    @TableField("dept_id")
    private String deptId;

    /**
     * 科室名称
     */
    @TableField("dept_name")
    private String deptName;

    /**
     * 条形码
     */
    @TableField("barcode")
    private String barcode;

    /**
     * 生产日期
     */
    @TableField("produce_date")
    private Date produceDate;


    /**
     * 批号
     */
    @TableField("batch_no")
    private String batchNo;

    /**
     * 有效期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @TableField("expiry_date")
    private Date expiryDate;

    /**
     * 创建人
     */
    @TableField("creator")
    private String creator;

    /**
     * 创建人Id
     */
    @TableField("creator_id")
    private String creatorId;

    /**
     * 修改人
     */
    @TableField("updator")
    private String updator;

    /**
     * 修改人Id
     */
    @TableField("updator_id")
    private String updatorId;

    /**
     * 是否打印
     */
    @TableField("is_print")
    private String isPrint;

    /**
     * 状态:-1-二级库待入库;0-一级库入库;1-一级库出库;2-二级库入库;3-领用;4-已使用;5-已计费;6-作废;7-退回;8-退货;9-移出;
     * 10-移入;11-退货暂存;12-调拨出库;13-调拨入库;14-移除;15-退费待审核;16-退费审核失败;17-已退费;18-最终使用;
     * 19-计费提报;20-拒收;21-归还;22-特殊消耗;24-取消计费提报;25-强制退回;26-维修;27-患者借出;28-病区借出;
     * 29-送消暂存;30-送消领取;31-请求计费;32-请求退费;33-医嘱领用;34-急救领用;35-自管领用;36-补录领用;37-返还;
     * 38-盘亏;39-盘盈;40-盘盈入库;41-盘亏出库;
     * 70-禁止操作;
     */
    @TableField("status")
    private String status;

    /**
     * 耗材移除次数
     */
    @TableField("delete_count")
    private Integer deleteCount;


    /**
     * 库存
     */
    @TableField(exist = false)
    private Integer stockNum;


    /**
     * 耗材数量
     */
    @TableField("cst_num")
    private Integer cstNum;


    /**
     * 待入库数量
     */
    @TableField(exist = false)
    private Integer waitStorageNum;

    /**
     * 待入库epc列表
     */
    @TableField(exist = false)
    private String waitStorageEpcs;

    /**
     * 领用人id
     */
    @TableField(exist = false)
    private String takeId;
    /**
     * 领用人姓名
     */
    @TableField(exist = false)
    private String takeName;

    /**
     * 本次补录数量
     */
    @TableField(exist = false)
    private Integer entryNum;

    /**
     * 是否相同柜子
     */
    @TableField(exist = false)
    private Boolean isSameDevice;

    /**
     * Rfid扫描入柜或出柜操作 true-入柜；false-出柜
     */
    @TableField(exist = false)
    private Boolean inOpt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
