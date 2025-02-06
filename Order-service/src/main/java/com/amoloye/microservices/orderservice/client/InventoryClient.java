package com.amoloye.microservices.orderservice.client;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/api/inventory")
public interface InventoryClient {

    @GetExchange
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);


}

//@HttpExchange("/api/inventory")
//public interface InventoryClient {
//
//    Logger log = LoggerFactory.getLogger(InventoryClient.class);
//
//    @GetExchange
//    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
//    @Retry(name = "inventory")
//    boolean isInStock(@RequestParam("skuCode") String skuCode, @RequestParam("quantity") Integer quantity);
//
//    // Ensure fallbackMethod is in the interface
//    default boolean fallbackMethod(String skuCode, Integer quantity, Throwable throwable) {
//        log.warn("Fallback: Cannot get inventory for SKU {}, reason: {}", skuCode, throwable.getMessage());
//        return false;
//    }
//}