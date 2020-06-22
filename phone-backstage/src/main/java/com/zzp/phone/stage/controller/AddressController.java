package com.zzp.phone.stage.controller;

import com.zzp.phone.stage.exception.PhoneException;
import com.zzp.phone.stage.form.adress.AddressSaveForm;
import com.zzp.phone.stage.form.adress.AddressUpdateForm;
import com.zzp.phone.stage.service.AddressService;
import com.zzp.phone.stage.util.ResultVoUtil;
import com.zzp.phone.stage.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

/**
 * 地址控制层接口
 * <p>
 *  //TODO
 *  AddressController.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/28 1:05
 * @see  AddressController
 **/
@Slf4j
@RestController
@RequestMapping("/address")
@Api(value = "地址接口",tags = "测试地址功能")
public class AddressController {
    @Resource
    private AddressService addressService;

    @ApiOperation(value = "展示所有地址",notes = "查找数据库保存的地址")
    @GetMapping("/list")
    public ResultVo<?> list(){
        return ResultVoUtil.success(addressService.findAll());
    }

    @ApiOperation(value = "添加地址",notes = "创建出地址")
    @PostMapping("/create")
    public ResultVo<?> create(@Valid @RequestBody AddressSaveForm addressForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【添加地址】参数错误,addressForm={}",addressForm);
            throw new PhoneException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        var addressUpdateForm = new AddressUpdateForm();
        BeanUtils.copyProperties(addressForm,addressUpdateForm);
        addressService.saveOrUpdate(addressUpdateForm);
        return ResultVoUtil.success(null);
    }

    @ApiOperation(value = "更新地址",notes = "修改地址")
    @PutMapping("/update")
    public ResultVo<?> update(@RequestBody AddressUpdateForm addressForm){
        if(addressForm.getId() == null){
            log.error("【修改地址】参数错误,addressForm={}",addressForm);
            throw new PhoneException("需要修改的address id为null");
        }
        addressService.saveOrUpdate(addressForm);
        return ResultVoUtil.success(null);
    }

}
