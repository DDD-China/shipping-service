package com.dmall.shippingservice.contractTest;

import com.dmall.shippingservice.ShippingServiceApplication;
import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.service.ShippingService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

@Ignore
@SpringBootTest(classes = ShippingServiceApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ShippingBase {

    @Autowired
    WebApplicationContext wac;

    @MockBean
    ShippingService shippingService;

    @Before
    public void setup() {
        setupMock();
        RestAssuredMockMvc.webAppContextSetup(wac);
    }

    private void setupMock() {

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

        when(shippingService.findByOrderId(anyLong())).thenReturn(shippings);
        when(shippingService.save(any(Shipping.class))).thenReturn(10L);
        when(shippingService.saveLogistic(anyLong(), any(Logistic.class))).thenReturn(100L);
    }
}
