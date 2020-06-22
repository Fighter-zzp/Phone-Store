package com.zzp.phone.stage.service;


import com.zzp.phone.stage.dto.OrderDto;
import com.zzp.phone.stage.vo.OrderDetailVo;
/**
 * 订单接口
 * <p>
 *  //TODO
 *  OrderService.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/27 21:32
 * @see  OrderService
 **/
public interface OrderService {
    /**
     * 创建订单
     * @param orderDto 订单dto {@link OrderDto}
     * @return {@link OrderDto}
     */
    OrderDto createOrder(OrderDto orderDto);

    /**
     * 通过订单id查找订单详情
     * @param orderId 订单id
     * @return {@link OrderDetailVo}
     */
    OrderDetailVo findOrderDetailByOrderId(String orderId);

    /**
     * 订单支付
     * @param orderId 订单id
     * @return 支付信息
     */
    String payOrder(String orderId);
}
