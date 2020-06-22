package com.zzp.phone.stage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
/**
 * sku 的组合列表数据
 * <p>
 *  //TODO
 *  PhoneSpecsCasVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 22:38
 * @see  PhoneSpecsCasVo
 **/
@Data
public class PhoneSpecsCasVo {
    /**
     * 价格id
     */
    @JsonProperty("s1")
    private Integer specsId;
    /**
     * 价格
     */
    @JsonProperty("price")
    private BigDecimal specsPrice;
    /**
     * 库存量
     */
    @JsonProperty("stock_num")
    private Integer specsStock;
}
