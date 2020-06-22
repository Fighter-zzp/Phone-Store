package com.zzp.phone.stage;

import com.zzp.phone.stage.mapper.BuyerAddressMapper;
import com.zzp.phone.stage.mapper.OrderMasterMapper;
import com.zzp.phone.stage.mapper.PhoneInfoMapper;
import com.zzp.phone.stage.service.OrderService;
import com.zzp.phone.stage.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PhoneStageApplicationTests {

    @Resource
    private BuyerAddressMapper buyerAddressMapper;
    @Resource
    private PhoneInfoMapper phoneInfoMapper;
    @Resource
    private PhoneService phoneService;
    @Test
    void contextLoads() {
        phoneService.subStock(1,1);
    }

    @Resource
    private OrderService orderService;

    @Test
    void test1(){
        var o1 = "463443526666689376";
        var o2 = "dssa";
        var s = orderService.findOrderDetailByOrderId(o2);
        System.out.println(s);
    }

}
