package com.zzp.phone.stage.enums;

import lombok.Getter;

/**
 * 结果返回
 * <p>
 *  //TODO
 *  ResultEnum.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:08
 * @see  ResultEnum
 **/
@Getter
public enum ResultEnum {
    /**
     * 输入异常消息
     */
    PHONE_STOCK_ERROR(0,"手机库存不足"),
    ORDER_NOT_EXIST(1,"订单不存在"),
    SPECS_NOT_EXIST(2,"规格不存在"),
    PHONE_NOT_EXIST(3,"手机不存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
