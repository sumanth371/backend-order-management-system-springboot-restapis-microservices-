package com.arjun.Inventoryserv.Respository;

import com.arjun.Inventoryserv.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {


   List<Inventory> findBySkuCodeIn(List<String> skucode);

 //  Arrays findBySkuCodeIn(List<String> skuCode);
}
