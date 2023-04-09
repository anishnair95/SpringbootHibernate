package com.springhibernate.springboothibernate.service;

import com.springhibernate.springboothibernate.entity.Product;
import com.springhibernate.springboothibernate.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {

        LOGGER.info("Inside saveProduct");
        return productRepository.saveProduct(product);
    }


    @Override
    public List<Product> getProducts() {
        LOGGER.info("Inside getProducts");
        return productRepository.findAll();
    }

    @Override
    public String saveProducts(List<Product> products) {
        LOGGER.info("Inside saveProducts");
        return productRepository.saveAll(products);
    }

}
