package com.arjun.orderser.service;

import com.arjun.orderser.dto.InventoryResponse;
import com.arjun.orderser.dto.orderLineItemsDto;
import com.arjun.orderser.dto.orderRequest;
import com.arjun.orderser.model.order;
import com.arjun.orderser.model.orderLineItems;
import com.arjun.orderser.repository.orderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service

public class orderService {

    @Autowired
    private orderRepository orderRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;
    public String createOrder(orderRequest orderRequest){
        order or=new order();
        List<orderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtoList().stream().map(item->maptoDto(item)).toList();
         or.setOrderNumber(UUID.randomUUID().toString());
         or.setOrderLineItemsList(orderLineItems);

        List<String>skuCodes= or.getOrderLineItemsList().stream().map(orderLineItem->orderLineItem.getSkuCode()).toList();

         //calling inventory service and place order if product is in stock
      InventoryResponse[] InventoryResponseArray=webClientBuilder.build().get().uri("http://inventory-service/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build()).retrieve().bodyToMono(InventoryResponse[].class).block();
      boolean allProducts= Arrays.stream(InventoryResponseArray).allMatch(InventoryResponse->InventoryResponse.isInStock());
      if(allProducts){
          orderRepository.save(or);
          return "orderplaced successfull";
      }
      else{
          throw new IllegalArgumentException("sorry,product is not in stock");
      }


    }


    public orderLineItems maptoDto(orderLineItemsDto orderLineItemsDto2){
        orderLineItems orderLineItemsDto1=new orderLineItems();
        orderLineItemsDto1.setQuantity(orderLineItemsDto2.getQuantity());
        orderLineItemsDto1.setSkuCode(orderLineItemsDto2.getSkuCode());
        orderLineItemsDto1.setPrice(orderLineItemsDto2.getPrice());
        return orderLineItemsDto1;
    }
}
