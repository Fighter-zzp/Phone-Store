package com.zzp.phone.stage.controller;

import com.zzp.phone.stage.service.PhoneService;
import com.zzp.phone.stage.util.ResultVoUtil;
import com.zzp.phone.stage.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 手机控制层
 * <p>
 *  //TODO
 *  PhoneController.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 23:04
 * @see  PhoneController
 **/
@RestController
@RequestMapping("/phone")
@Api(value = "移动端手机接口",tags = "用来测试接口")
public class PhoneController {
    @Resource
    private PhoneService phoneService;

    @ApiOperation(value = "手机主页展示",notes = "刷新时加载")
    @GetMapping("/index")
    public ResultVo<?> index(){
        return ResultVoUtil.success(phoneService.findDataVo());
    }

    @ApiOperation(value = "通过手机类型来查找手机信息",notes = "用于购买时的展示")
    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVo<?> findByCategoryType(
            @PathVariable("categoryType") Integer categoryType){
        return ResultVoUtil.success(phoneService.findPhoneInfoVoByCategoryType(categoryType));
    }

    @ApiOperation(value = "通过手机id显示规格信息",notes = "用于购买时的展示")
    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVo<?> findSpecsByPhoneId(
            @PathVariable("phoneId") Integer phoneId){
        return ResultVoUtil.success(phoneService.findSpecsByPhoneId(phoneId));
    }
}
