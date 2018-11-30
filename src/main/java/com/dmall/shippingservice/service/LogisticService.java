package com.dmall.shippingservice.service;

import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.repository.LogisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticService {

    @Autowired
    private LogisticRepository repository;

    public void createLogistic(Logistic logistic){
        repository.save(logistic);
    };
}
