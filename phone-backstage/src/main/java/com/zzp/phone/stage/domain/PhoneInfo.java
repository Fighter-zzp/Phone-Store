package com.zzp.phone.stage.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

/**
 * 商品表
 */
@Data
@Table(name = "phone_info")
public class PhoneInfo implements Serializable {
    @Id
    @Column(name = "phone_id")
    @GeneratedValue(generator = "JDBC")
    private Integer phoneId;

    /**
     * 商品名称
     */
    @Column(name = "phone_name")
    private String phoneName;

    /**
     * 商品单价
     */
    @Column(name = "phone_price")
    private BigDecimal phonePrice;

    /**
     * 描述
     */
    @Column(name = "phone_description")
    private String phoneDescription;

    /**
     * 库存
     */
    @Column(name = "phone_stock")
    private Integer phoneStock;

    /**
     * 小图
     */
    @Column(name = "phone_icon")
    private String phoneIcon;

    /**
     * 类目编号
     */
    @Column(name = "category_type")
    private Integer categoryType;

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

    /**
     * 标签
     */
    @Column(name = "phone_tag")
    private String phoneTag;

    private static final long serialVersionUID = 1L;
}