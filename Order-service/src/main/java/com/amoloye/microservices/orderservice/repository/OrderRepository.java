package com.amoloye.microservices.orderservice.repository;

import com.amoloye.microservices.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {


}
