package com.dmall.shippingservice.contractTest;

import com.dmall.shippingservice.ShippingServiceApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@Ignore
@SpringBootTest(classes = ShippingServiceApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ShippingBase {

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(wac);
    }
}
