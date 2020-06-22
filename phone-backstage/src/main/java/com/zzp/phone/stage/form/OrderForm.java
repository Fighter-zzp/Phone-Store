package com.zzp.phone.stage.form;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * 后台order表单验证
 * <p>
 *  //TODO
 *  OrderForm.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:24
 * @see  OrderForm
 **/
@Data
public class OrderForm {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String tel;
    @NotEmpty(message = "地址不能为空")
    private String address;
    @NotNull(message = "规格不能为空")
    private Integer specsId;
    @NotNull(message = "数量不能为空")
    private Integer quantity;
}
