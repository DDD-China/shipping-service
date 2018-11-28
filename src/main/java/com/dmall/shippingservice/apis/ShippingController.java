package com.dmall.shippingservice.apis;

import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

    @Autowired
    ShippingService shippingService;

    @GetMapping
    public List<Shipping> getShippingsByOrderId(@RequestParam(name = "orderId") Long orderId) {
        return shippingService.findByOrderId(orderId);

    }

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {

        return ResponseEntity.status(HttpStatus.CREATED).body(shipping);
    }

    @PostMapping("/{id}/logistics")
    public ResponseEntity<Shipping> createShippingLogistics(@RequestBody Logistic logistic) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
