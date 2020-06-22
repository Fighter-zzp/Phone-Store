package com.zzp.phone.stage.vo;

import lombok.Data;

import java.util.Map;

/**
 * 包vo
 * <p>
 *  //TODO
 *  SpecsPackageVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:16
 * @see  SpecsPackageVo
 **/
@Data
public class SpecsPackageVo {
    private Map<String,String> goods;
    private SkuVo sku;
}
