package com.springhibernate.springboothibernate.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty(value="id")
    private int id;
    @JsonProperty(value="name")
    private String name;
    @JsonProperty(value="quantity")
    private int quantity;
    @JsonProperty(value="price")
    private double price;
}
