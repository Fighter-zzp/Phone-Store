package com.zzp.phone.stage.service.impl;

import com.zzp.phone.stage.domain.OrderMaster;
import com.zzp.phone.stage.dto.OrderDto;
import com.zzp.phone.stage.enums.PayStatusEnum;
import com.zzp.phone.stage.enums.ResultEnum;
import com.zzp.phone.stage.exception.PhoneException;
import com.zzp.phone.stage.mapper.OrderMasterMapper;
import com.zzp.phone.stage.mapper.PhoneInfoMapper;
import com.zzp.phone.stage.mapper.PhoneSpecsMapper;
import com.zzp.phone.stage.service.OrderService;
import com.zzp.phone.stage.service.PhoneService;
import com.zzp.phone.stage.util.SnowFlakeIdUtil;
import com.zzp.phone.stage.vo.OrderDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * 订单服务实现
 * <p>
 * //TODO
 * OrderServiceImpl.java
 * </p>
 *
 * @author 佐斯特勒
 * @version v1.0.0
 * @date 2020/5/28 1:19
 * @see OrderServiceImpl
 **/
@Service
@Slf4j
@Transactional(rollbackFor = {PhoneException.class, Exception.class})
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMasterMapper orderMasterMapper;
    @Resource
    private PhoneInfoMapper phoneInfoMapper;
    @Resource
    private PhoneSpecsMapper phoneSpecsMapper;
    @Resource
    private PhoneService phoneService;
    @Resource
    private SnowFlakeIdUtil snowFlakeIdUtil;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        var orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto, orderMaster);

        // 获取手机规格
        var phoneSpecs = phoneSpecsMapper.selectByPrimaryKey(orderMaster.getSpecsId());

        BeanUtils.copyProperties(Optional.ofNullable(phoneSpecs)
                .orElseThrow(() -> {
                            log.error("【创建订单】规格不存在,phoneSpecs={}", (Object) null);
                            return new PhoneException(ResultEnum.SPECS_NOT_EXIST);
                        }), orderMaster);

        // 获取手机信息
        var phoneInfo = phoneInfoMapper.selectByPrimaryKey(phoneSpecs.getPhoneId());

        BeanUtils.copyProperties(Optional.ofNullable(phoneInfo)
                .orElseThrow(() -> {
                            log.error("【创建订单】手机不存在,phoneInfo={}", (Object) null);
                            return new PhoneException(ResultEnum.PHONE_NOT_EXIST);
                        }), orderMaster);

        // 计算总价
        var orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(orderDto.getPhoneQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);

        // 插入id
        orderMaster.setOrderId(String.valueOf(snowFlakeIdUtil.nextId()));
        orderDto.setOrderId(orderMaster.getOrderId());

        // 更改支付状态
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());

        // 存入订单
        orderMasterMapper.insert(orderMaster);
        // 减轻库存
        phoneService.subStock(orderDto.getSpecsId(), orderDto.getPhoneQuantity());

        return orderDto;
    }

    @Override
    public OrderDetailVo findOrderDetailByOrderId(String orderId) {
        var orderMaster = orderMasterMapper.selectByPrimaryKey(orderId);

        // 映射订单
        var orderDetailVo = new OrderDetailVo();
        BeanUtils.copyProperties(Optional.ofNullable(orderMaster)
                .orElseThrow(() -> {
                    log.error("【查询订单】订单不存在,orderMaster={}", (Object) null);
                    return new PhoneException(ResultEnum.ORDER_NOT_EXIST);
                }), orderDetailVo);

        orderDetailVo.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100), 2, RoundingMode.HALF_UP) + ".00");
        // 返回订单信息
        return orderDetailVo;
    }


    @Override
    public String payOrder(String orderId) {
        // 查找订单
        var orderMaster = orderMasterMapper.selectByPrimaryKey(orderId);

        Optional.ofNullable(orderMaster)
                .or(() -> {
                    log.error("【支付订单】订单不存在,orderMaster={}", (Object) null);
                    throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
                })
                .filter(om -> om.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode()))
                .ifPresentOrElse(o -> {
                    var om = new OrderMaster();
                    om.setOrderId(o.getOrderId());
                    om.setPayStatus(PayStatusEnum.PAID.getCode());
                    orderMasterMapper.updateByPrimaryKeySelective(om);
                }, () -> log.error("【支付订单】订单已支付,orderMaster={}", orderMaster));

        return orderId;
    }
}
