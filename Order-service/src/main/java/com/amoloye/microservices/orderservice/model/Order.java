package com.amoloye.microservices.orderservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


//@ToString
//@RequiredArgsConstructor
@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;



}
