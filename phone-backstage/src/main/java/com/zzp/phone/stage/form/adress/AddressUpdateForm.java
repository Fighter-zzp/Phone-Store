package com.zzp.phone.stage.form.adress;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 后台form表单校验 更新
 * <p>
 *  //TODO 更新地址不设置校验
 *  AddressForm.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:22
 * @see  AddressUpdateForm
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressUpdateForm extends BaseForm{
    private String name;
    private String tel;
    private String province;
    private String city;
    private String county;
    private String areaCode;
    private String addressDetail;
}
