package com.arjun.ProductSer.Controllers;

import com.arjun.ProductSer.Dto.ProductDto;
import com.arjun.ProductSer.Dto.ProductResponse;
import com.arjun.ProductSer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")

public class ProductController {

   @Autowired
   ProductService productService;
   @PostMapping
   public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
      productService.createProduct(productDto);
      return new ResponseEntity<ProductDto>(HttpStatus.CREATED);

   }
   @GetMapping
   @ResponseStatus(HttpStatus.OK)
   public List<ProductResponse> getAllProducts(){

     return productService.getAllProducts();

   }
}
