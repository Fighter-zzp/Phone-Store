package com.zzp.phone.stage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * 手机价格规格vo
 * <p>
 *  //TODO
 *  PhoneSpecsVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 22:34
 * @see  PhoneSpecsVo
 **/
@Data
public class PhoneSpecsVo {
    /**
     * 规格id
     */
    @JsonProperty("id")
    private Integer specsId;
    /**
     * 规格名
     */
    @JsonProperty("name")
    private String specsName;
    /**
     * 图片地址
     */
    @JsonProperty("imgUrl")
    private String specsIcon;
    /**
     * 规格预览图地址
     */
    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
