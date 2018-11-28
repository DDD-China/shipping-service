package com.dmall.shippingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Logistic {
    private Long orderId;
    private String express;
    private String info;
    private Long updateAt;
}
