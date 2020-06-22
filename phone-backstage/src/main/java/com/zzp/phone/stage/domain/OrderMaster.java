package com.zzp.phone.stage.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import lombok.Data;

/**
 * 订单表
 *
 * @author ZZP
 */
@Data
@Table(name = "order_master")
public class OrderMaster implements Serializable {
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 买家名字
     */
    @Column(name = "buyer_name")
    private String buyerName;

    /**
     * 买家电话
     */
    @Column(name = "buyer_phone")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @Column(name = "buyer_address")
    private String buyerAddress;

    /**
     * 商品编号
     */
    @Column(name = "phone_id")
    private Integer phoneId;

    /**
     * 商品名称
     */
    @Column(name = "phone_name")
    private String phoneName;

    /**
     * 商品数量
     */
    @Column(name = "phone_quantity")
    private Integer phoneQuantity;

    /**
     * 商品小图
     */
    @Column(name = "phone_icon")
    private String phoneIcon;

    /**
     * 规格编号
     */
    @Column(name = "specs_id")
    private Integer specsId;

    /**
     * 规格名称
     */
    @Column(name = "specs_name")
    private String specsName;

    /**
     * 规格单价
     */
    @Column(name = "specs_price")
    private BigDecimal specsPrice;

    /**
     * 订单总金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 支付状态，默认0未支付
     */
    @Column(name = "pay_status")
    private Byte payStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}