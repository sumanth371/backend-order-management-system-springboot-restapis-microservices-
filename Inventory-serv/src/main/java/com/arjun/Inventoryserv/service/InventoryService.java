package com.arjun.Inventoryserv.service;

import com.arjun.Inventoryserv.Dto.InventoryResponse;
import com.arjun.Inventoryserv.Respository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.List;
@Service
@Slf4j
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;
@Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode ){
//    log.info("Wait started");
//    try {
//        Thread.sleep(10000);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
//    log.info("wait ended");
      return  inventoryRepository.findBySkuCodeIn(skuCode).stream().map(Inventory->InventoryResponse.builder().
              skuCode(Inventory.getSkuCode()).isInStock(Inventory.getQuentity()>0).build()).toList();


}
}
