package com.zzp.phone.stage.form.adress;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 后台form表单校验
 * <p>
 *  //TODO
 *  AddressForm.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:22
 * @see  AddressSaveForm
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressSaveForm extends BaseForm{
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String tel;
    @NotEmpty(message = "省不能为空")
    private String province;
    @NotEmpty(message = "市不能为空")
    private String city;
    @NotEmpty(message = "区不能为空")
    private String county;
    @NotEmpty(message = "编码不能为空")
    private String areaCode;
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
