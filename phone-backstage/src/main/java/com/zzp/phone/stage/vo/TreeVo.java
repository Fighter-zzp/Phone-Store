package com.zzp.phone.stage.vo;

import lombok.Data;

import java.util.List;
/**
 * 手机vant的tree数据
 * <p>
 *  //TODO
 *  TreeVO.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 22:48
 * @see  TreeVo
 **/
@Data
public class TreeVo {
    private String k = "规格";
    private List<PhoneSpecsVo> v;
    private String k_s = "s1";
}
