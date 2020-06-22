package com.zzp.phone.stage.controller;

import com.zzp.phone.stage.dto.OrderDto;
import com.zzp.phone.stage.exception.PhoneException;
import com.zzp.phone.stage.form.OrderForm;
import com.zzp.phone.stage.service.OrderService;
import com.zzp.phone.stage.util.ResultVoUtil;
import com.zzp.phone.stage.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Objects;
/**
 * 订单控制层
 * <p>
 *  //TODO
 *  OrderController.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/28 2:13
 * @see  OrderController
 **/
@RestController
@RequestMapping("/order")
@Slf4j
@Api(value = "订单控制接口",tags = "订单管理")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation(value = "创建用户订单",notes = "订单创建")
    @PostMapping("/create")
    public ResultVo<?> create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误,orderForm={}",orderForm);
            throw new PhoneException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }

        var orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getTel());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setSpecsId(orderForm.getSpecsId());
        orderDto.setPhoneQuantity(orderForm.getQuantity());

        var result = orderService.createOrder(orderDto);

        var map = new HashMap<String,String>(16);
        map.put("orderId",result.getOrderId());

        return ResultVoUtil.success(map);
    }

    @ApiOperation(value = "展示订单详情",notes = "根据订单id查找订单详情")
    @GetMapping("/detail/{orderId}")
    public ResultVo<?> findOrderDetail(
            @PathVariable("orderId") String orderId){
        return ResultVoUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    @ApiOperation(value = "更新之后状态",notes = "根据订单id更新支付状态")
    @PutMapping("/pay/{orderId}")
    public ResultVo<?> pay(
            @PathVariable("orderId") String orderId){
        var map = new HashMap<String,String>(16);
        map.put("orderId",orderService.payOrder(orderId));
        return ResultVoUtil.success(map);
    }

}
