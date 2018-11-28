package com.dmall.shippingservice.service;

import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    public List<Shipping> findByOrderId(Long orderId) {
        return Arrays.asList(Shipping.builder()
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
                .build()
        );
    }
}
