package com.dmall.shippingservice.repository;

import com.dmall.shippingservice.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    List<Shipping> findAllByOrderId(Long orderId);
}
