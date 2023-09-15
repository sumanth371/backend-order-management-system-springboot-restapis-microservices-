package com.arjun.orderser.controller;

import com.arjun.orderser.dto.orderRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.arjun.orderser.service.orderService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/order")
@Transactional
public class orderController {

    @Autowired
    private orderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name="inventory",fallbackMethod = "fallbackMethod")
    @TimeLimiter(name="inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> createOrder(@RequestBody  orderRequest orderRequest){
        return CompletableFuture.supplyAsync(()-> orderService.createOrder(orderRequest)) ;
    }
    public CompletableFuture<String> fallbackMethod(orderRequest orderRequest, RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()->"oops! something went wrong") ;
    }
}
