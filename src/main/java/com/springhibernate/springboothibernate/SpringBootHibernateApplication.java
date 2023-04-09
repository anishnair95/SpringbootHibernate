package com.springhibernate.springboothibernate;

import com.springhibernate.springboothibernate.entity.Product;
import com.springhibernate.springboothibernate.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
public class SpringBootHibernateApplication {

//    @Autowired
//    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateApplication.class, args);
    }

//    @Override
//    public void run(String ...args) {
//        Product product = Product.builder()
//                                 .name("Product new")
//                                 .price(250.12)
//                                 .quantity(2)
//                                 .build();
//
//        productRepository.saveProduct(product);
//    }
}
