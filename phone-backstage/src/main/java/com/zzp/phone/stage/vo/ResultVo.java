package com.zzp.phone.stage.vo;

import lombok.Data;
/**
 * 结果vo
 * <p>
 *  //TODO
 *  ResultVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 23:07
 * @see  ResultVo
 **/
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;
}
