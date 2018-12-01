package com.dmall.shippingservice.service;

import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.repository.LogisticRepository;
import com.dmall.shippingservice.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;
    @Autowired
    private LogisticRepository logisticRepository;

    public Shipping save(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public void saveLogistic(Logistic logistic){
        logisticRepository.save(logistic);
    }

    public List<Shipping> getShippingByOrderId(String orderId) {
        return Arrays.asList(Shipping.builder().orderId(orderId).build());
    }

    public List<Shipping> findById(String orderId) {
        return shippingRepository.getShippingByOrderId(orderId);
    }
}
