package com.zzp.phone.stage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
/**
 * 订单详情vo
 * <p>
 *  //TODO
 *  OrderDetailVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:29
 * @see  OrderDetailVo
 **/
@Data
public class OrderDetailVo {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 购买者名
     */
    private String buyerName;
    /**
     * 购买者电话
     */
    @JsonProperty("tel")
    private String buyerPhone;
    /**
     * 购买者地址
     */
    @JsonProperty("address")
    private String buyerAddress;
    /**
     * 手机量
     */
    @JsonProperty("num")
    private Integer phoneQuantity;
    /**
     * 手机名
     */
    private String phoneName;
    /**
     * 规格名
     */
    @JsonProperty("specs")
    private String specsName;
    /**
     * 价格
     */
    @JsonProperty("price")
    private String specsPrice;
    /**
     * 图标
     */
    @JsonProperty("icon")
    private String phoneIcon;
    /**
     * 购买金额
     */
    @JsonProperty("amount")
    private BigDecimal orderAmount;
    /**
     * 购买状态
     */
    private Integer payStatus;
    /**
     * 货物 初始10
     */
    private Integer freight = 10;
}
