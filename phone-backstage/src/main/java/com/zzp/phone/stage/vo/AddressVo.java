package com.zzp.phone.stage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 地址vo
 * <p>
 *  //TODO
 *  AddressVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:20
 * @see  AddressVo
 **/
@Data
@AllArgsConstructor
public class AddressVo {
    /**
     * 地址id
     */
    private Integer id;
    /**
     * 地域码
     */
    private String areaCode;
    /**
     *
     * 地名
     */
    private String name;
    /**
     * 电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;
}

