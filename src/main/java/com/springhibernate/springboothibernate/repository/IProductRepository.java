package com.springhibernate.springboothibernate.repository;

import com.springhibernate.springboothibernate.entity.Product;

import java.util.List;

public interface IProductRepository {
     Product saveProduct(Product product);

     List<Product> findAll();

    String saveAll(List<Product> products);
}
