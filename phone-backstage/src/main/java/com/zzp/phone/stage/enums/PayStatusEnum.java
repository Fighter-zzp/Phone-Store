package com.zzp.phone.stage.enums;

import lombok.Getter;
/**
 * 支付转态码
 * <p>
 *  //TODO
 *  PayStatusEnum.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:06
 * @see  PayStatusEnum
 **/
@Getter
public enum PayStatusEnum {
    /**
     * 未支付
     */
    UNPIAD((byte)0,"未支付"),
    /**
     * 已支付
     */
    PAID((byte)1,"已支付");
    /**
     * 支付码
     */
    private final Byte code;
    /**
     * 支付信息
     */
    private final String msg;

    PayStatusEnum(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

