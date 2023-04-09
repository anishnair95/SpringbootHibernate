package com.springhibernate.springboothibernate.service;

import com.springhibernate.springboothibernate.entity.Product;

import java.util.List;


public interface IProductService {

    Product saveProduct(Product product);

    List<Product> getProducts();

    String saveProducts(List<Product> products);


}
