package com.amoloye.microservices.orderservice.service;

import com.amoloye.microservices.orderservice.client.InventoryClient;
import com.amoloye.microservices.orderservice.dto.OrderRequest;
import com.amoloye.microservices.orderservice.model.Order;
import com.amoloye.microservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){
      var isProductInStock=  inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

      if (isProductInStock) {
          Order order = new Order();
          order.setOrderNumber(UUID.randomUUID().toString());
          order.setPrice(orderRequest.price());
          order.setSkuCode(orderRequest.skuCode());
          order.setQuantity(orderRequest.quantity());

          orderRepository.save(order);
      }else{
          throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
      }




    }
}
