package com.zzp.phone.stage.service;


import com.zzp.phone.stage.form.adress.AddressSaveForm;
import com.zzp.phone.stage.form.adress.AddressUpdateForm;
import com.zzp.phone.stage.vo.AddressVo;

import java.util.List;
/**
 * 地址服务接口
 * <p>
 *  //TODO
 *  AddressService.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:24
 * @see  AddressService
 **/
public interface AddressService {
    /**
     * 查找所有的地址
     * @return {@link List<AddressVo>}
     */
    List<AddressVo> findAll();

    /**
     * 保存或更新地址
     * @param addressForm {@link AddressSaveForm}
     */
    void saveOrUpdate(AddressUpdateForm addressForm);
}
