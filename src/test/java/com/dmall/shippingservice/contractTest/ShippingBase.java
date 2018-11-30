package com.dmall.shippingservice.contractTest;

import com.dmall.shippingservice.apis.ShippingController;
import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.service.ShippingService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ShippingBase {

    @Before
    public void setup() {
        final ShippingService shippingService = mock(ShippingService.class);

        List<Shipping> shippings = Arrays.asList(Shipping.builder()
                .orderId(1L)
                .quantity(10L)
                .address("北京国际会议中心308")
                .logistics(Arrays.asList(
                        Logistic.builder()
                                .orderId(1L)
                                .express("方通快递")
                                .updateAt(1234567L)
                                .info("已经出库").build()
                ))
                .build());

//        when(shippingService.findByOrderId(anyLong())).thenReturn(shippings);
        RestAssuredMockMvc.standaloneSetup(new ShippingController(shippingService));
    }
}
