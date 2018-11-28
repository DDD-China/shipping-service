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
    ShippingRepository shippingRepository;

    @Autowired
    LogisticRepository logisticRepository;

    public List<Shipping> findByOrderId(Long orderId) {
        return shippingRepository.findAllByOrderId(orderId);
    }

    public Long save(Shipping shipping) {
        Shipping save = shippingRepository.save(shipping);
        return save.getId();
    }

    public Long saveLogistic(Long shippingId, Logistic logisticRequest) {
        Shipping shipping = shippingRepository.findById(shippingId)
                .orElseThrow(RuntimeException::new);

        Logistic logistic = Logistic.builder()
                .shippingId(shippingId)
                .express(logisticRequest.getExpress())
                .info(logisticRequest.getInfo())
                .orderId(logisticRequest.getOrderId())
                .build();

        Logistic savedLogistic = logisticRepository.save(logistic);
        return savedLogistic.getId();
    }
}
