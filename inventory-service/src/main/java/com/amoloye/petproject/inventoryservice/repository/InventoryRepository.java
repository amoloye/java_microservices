package com.amoloye.petproject.inventoryservice.repository;

import com.amoloye.petproject.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
