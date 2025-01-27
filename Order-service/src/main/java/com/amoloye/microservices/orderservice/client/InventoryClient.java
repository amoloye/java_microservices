package com.amoloye.microservices.orderservice.client;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


public interface InventoryClient {
    //httpExchange for integration
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

    //we will also make configuration of RestClient in the config package



}
