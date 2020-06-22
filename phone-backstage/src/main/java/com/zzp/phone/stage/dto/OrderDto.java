package com.zzp.phone.stage.dto;

import lombok.Data;
/**
 * 订单dto
 * <p>
 *  //TODO
 *  OrderDto.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:26
 * @see  OrderDto
 **/
@Data
public class OrderDto {
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
    private String buyerPhone;
    /**
     * 购买者地址
     */
    private String buyerAddress;
    /**
     * 规格id
     */
    private Integer specsId;
    /**
     * 购买电话量
     */
    private Integer phoneQuantity;
}
