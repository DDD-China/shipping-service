package com.dmall.shippingservice.contractTest;

import com.dmall.shippingservice.apis.ShippingController;
import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.service.LogisticService;
import com.dmall.shippingservice.service.ShippingService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShippingBase {

    @Before
    public void setup() {
        final ShippingService shippingService = mock(ShippingService.class);
        final LogisticService logisticService = mock(LogisticService.class);

        List<Shipping> shippings = Arrays.asList(Shipping.builder()
                .orderId("1")
                .quantity(10L)
                .address("北京国际会议中心308")
                .logistics(Arrays.asList(
                        Logistic.builder()
                                .orderId(1L)
                                .express("方通快递")
                                .info("已经出库").build()
                ))
                .build());

        when(shippingService.findById(anyLong())).thenReturn(shippings);
        when(shippingService.save(any(Shipping.class))).thenReturn(buildShipping());

        RestAssuredMockMvc.standaloneSetup(new ShippingController(shippingService,logisticService));
    }

    private Shipping buildShipping() {
        return Shipping.builder().orderId("11").quantity(10L).address("北京国际会议中心").build();
    }
}
