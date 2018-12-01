package com.dmall.shippingservice.apis;

import com.dmall.shippingservice.model.Logistic;
import com.dmall.shippingservice.model.Shipping;
import com.dmall.shippingservice.service.LogisticService;
import com.dmall.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippings")
public class ShippingController {


    private final ShippingService shippingService;

    private final LogisticService logisticService;

    @Autowired
    public ShippingController(ShippingService shippingService,
                              LogisticService logisticService) {
        this.shippingService = shippingService;
        this.logisticService = logisticService;
    }

    @GetMapping()
    public List<Shipping> getShippingByOrderId1(@RequestParam("orderId") String orderId) {
        return shippingService.findById(orderId);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Shipping create(@RequestBody Shipping shipping) {
        return shippingService.save(shipping);
    }


    @PostMapping("{id}/logistics")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createLogistic(@RequestBody Logistic logistic,@PathVariable("id") long shippingId) {
        logistic.setShippingId(shippingId);
        logisticService.createLogistic(logistic);
    }
}
