package com.zzp.phone.stage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 手机信息vo
 * <p>
 *  //TODO
 *  PhoneInfoVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:15
 * @see  PhoneInfoVo
 **/
@Data
@AllArgsConstructor
public class PhoneInfoVo {
    /**
     * 手机id
     */
    @JsonProperty("id")
    private Integer phoneId;
    /**
     * 标题
     */
    @JsonProperty("title")
    private String phoneName;
    /**
     * 手机价格
     */
    @JsonProperty("price")
    private String phonePrice;
    /**
     * 手机描述
     */
    @JsonProperty("desc")
    private String phoneDescription;
    /**
     * 手机tag
     */
    private List<Map<String,String>> tag;
    /**
     * 手机icon
     */
    @JsonProperty("thumb")
    private String phoneIcon;
}
