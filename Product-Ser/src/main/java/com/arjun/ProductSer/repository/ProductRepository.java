package com.arjun.ProductSer.repository;

import com.arjun.ProductSer.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {
}
