package com.zzp.phone.stage.vo;

import lombok.Data;

import java.util.List;
/**
 * 按照vant的sku对象结构
 * <p>
 *  //TODO
 *  SkuVO.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 22:50
 * @see  SkuVo
 **/
@Data
public class SkuVo {
    /**
     * tree
     */
    private List<TreeVo> tree;
    /**
     * 所有 sku 的组合列表，比如红色、M 码为一个 sku 组合，红色、S 码为另一个组合
     */
    private List<PhoneSpecsCasVo> list;
    /**
     * 价格
     */
    private String price;
    /**
     * 商品总库存
     */
    private Integer stock_num;
    /**
     * 是否无规格商品
     */
    private Boolean none_sku = false;
    /**
     * 是否隐藏剩余库存
     */
    private Boolean hide_stock = false;
}
