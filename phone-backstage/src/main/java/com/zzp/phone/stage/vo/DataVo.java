package com.zzp.phone.stage.vo;

import lombok.Data;

import java.util.List;

/**
 * 数据vo
 * <p>
 *  //TODO
 *  用来展示手机类型和手机信息
 *  DataVO.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:14
 * @see  DataVo
 **/
@Data
public class DataVo {
    /**
     * 手机类型数据
     */
    private List<PhoneCategoryVo> categories;
    /**
     * 手机信息列表
     */
    private List<PhoneInfoVo> phones;
}