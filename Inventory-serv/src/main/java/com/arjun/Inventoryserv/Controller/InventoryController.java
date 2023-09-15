package com.arjun.Inventoryserv.Controller;


import com.arjun.Inventoryserv.Dto.InventoryResponse;
import com.arjun.Inventoryserv.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")

public class InventoryController {

@Autowired
    InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInstock(@RequestParam List<String> skuCode){
        System.out.println("hlo came baa");
           return inventoryService.isInStock(skuCode);

    }
}
