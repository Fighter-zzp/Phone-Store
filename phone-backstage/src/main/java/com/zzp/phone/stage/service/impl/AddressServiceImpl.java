package com.zzp.phone.stage.service.impl;

import com.zzp.phone.stage.domain.BuyerAddress;
import com.zzp.phone.stage.exception.PhoneException;
import com.zzp.phone.stage.form.adress.AddressSaveForm;
import com.zzp.phone.stage.form.adress.AddressUpdateForm;
import com.zzp.phone.stage.form.adress.BaseForm;
import com.zzp.phone.stage.mapper.BuyerAddressMapper;
import com.zzp.phone.stage.service.AddressService;
import com.zzp.phone.stage.vo.AddressVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * address服务接口实现
 * <p>
 * //TODO
 * AddressServiceImpl.java
 * </p>
 *
 * @author 佐斯特勒
 * @version v1.0.0
 * @date 2020/5/27 22:00
 * @see AddressServiceImpl
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class AddressServiceImpl implements AddressService {
    @Resource
    private BuyerAddressMapper buyerAddressMapper;

    @Override
    public List<AddressVo> findAll() {
        return buyerAddressMapper.selectAll().stream()
                .map(a -> new AddressVo(
                        a.getAddressId(),
                        a.getAreaCode(),
                        a.getBuyerName(),
                        a.getBuyerPhone(),
                        a.getBuyerAddress()
                )).collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdate(AddressUpdateForm addressForm) {
        var buyerAddress = new BuyerAddress();
        // 插入地址信息
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        var sb = addressForm.getProvince() +
                addressForm.getCity() +
                addressForm.getCounty() +
                addressForm.getAddressDetail();
        buyerAddress.setBuyerAddress(sb);
        buyerAddress.setAreaCode(addressForm.getAreaCode());
        // 由id判断是使用插入还是更新
        Optional.ofNullable(addressForm.getId())
                .ifPresentOrElse(id->{
                        buyerAddress.setAddressId(id);
                        buyerAddressMapper.updateByPrimaryKeySelective(buyerAddress);
                    }, () -> buyerAddressMapper.insertSelective(buyerAddress));
    }
}
