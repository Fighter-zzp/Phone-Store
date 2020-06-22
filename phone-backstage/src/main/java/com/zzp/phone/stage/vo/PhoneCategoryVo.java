package com.zzp.phone.stage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 手机数量vo
 * <p>
 *  //TODO
 *  PhoneCategoryVO.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:32
 * @see  PhoneCategoryVo
 **/
@Data
@AllArgsConstructor
public class PhoneCategoryVo {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
}

