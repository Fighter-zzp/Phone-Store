package com.zzp.phone.stage.exception;

import com.zzp.phone.stage.enums.ResultEnum;
/**
 * 手机异常
 * <p>
 *  //TODO
 *  PhoneException.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 22:59
 * @see  PhoneException
 **/
public class PhoneException extends RuntimeException {
    public PhoneException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }

    public PhoneException(String error) {
        super(error);
    }
}
