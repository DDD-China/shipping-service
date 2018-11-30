package com.dmall.shippingservice.repository;

import com.dmall.shippingservice.model.Logistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticRepository extends JpaRepository<Logistic,Long> {
}
