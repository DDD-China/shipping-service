package com.dmall.shippingservice.service;

import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.repository.LogisticRepository;
import com.dmall.shippingservice.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;
    @Autowired
    private LogisticRepository logisticRepository;

    public List<Shipping> getShippingByOrderId(long orderId){
        return shippingRepository.getShippingByOrderId(orderId);
    }

    public Shipping save(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public void saveLogistic(Logistic logistic){
        logisticRepository.save(logistic);
    }
}
