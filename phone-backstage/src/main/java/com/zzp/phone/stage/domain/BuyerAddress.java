package com.zzp.phone.stage.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

/**
 * 收货地址表
 * @author ZZP
 */
@Data
@Table(name = "buyer_address")
public class BuyerAddress implements Serializable {
    private static final long serialVersionUID = 4864827456090202573L;
    @Id
    @Column(name = "address_id")
    @GeneratedValue(generator = "JDBC")
    private Integer addressId;

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
     * 地址编码
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

}