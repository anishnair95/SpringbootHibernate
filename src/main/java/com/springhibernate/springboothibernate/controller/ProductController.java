package com.springhibernate.springboothibernate.controller;

import com.springhibernate.springboothibernate.entity.Product;
import com.springhibernate.springboothibernate.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {

    private final IProductService iProductService;

    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        Product productData = iProductService.saveProduct(product);
        if(productData==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return  productData;
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        List<Product> productList = iProductService.getProducts();

        if(productList==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return  productList;
    }

    @PostMapping("/bulk/products")
    public String addProducts(@RequestBody List<Product> products) {
        String response = iProductService.saveProducts(products);

        if(response==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return  response;
    }

}
