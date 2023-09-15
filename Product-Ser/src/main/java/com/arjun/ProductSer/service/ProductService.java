package com.arjun.ProductSer.service;

import com.arjun.ProductSer.Dto.ProductDto;
import com.arjun.ProductSer.Dto.ProductResponse;
import com.arjun.ProductSer.models.Product;
import com.arjun.ProductSer.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository pr;
     public void createProduct(ProductDto pd){
        Product p=Product.builder().name(pd.getName()).description(pd.getDescription()).price(pd.getPrice()).build();
        pr.save(p);
        log.info("product {} is saved",p.getId());
     }

    public List<ProductResponse> getAllProducts() {
         List<Product>lp=pr.findAll();
       return   lp.stream().map(product->convert(product)).toList();
    }

    public ProductResponse convert(Product product){
         ProductResponse productResponse= ProductResponse.builder().name(product.getName()).description(product.getDescription()).price(product.getPrice()).build();
         return productResponse;
    }
}
