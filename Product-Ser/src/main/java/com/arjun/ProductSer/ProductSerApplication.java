package com.arjun.ProductSer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })



public class ProductSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSerApplication.class, args);
	}

}
