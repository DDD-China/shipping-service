package com.dmall.shippingservice.apis;

import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

    @GetMapping
    public List<Shipping> getShippingsByOrderId(@RequestParam(name = "orderId") Long orderId) {
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

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {

        return ResponseEntity.status(HttpStatus.CREATED).body(shipping);
    }

    @PostMapping("/{id}/logistics")
    public ResponseEntity<Shipping> createShippingLogistics(@RequestBody Logistic logistic) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
