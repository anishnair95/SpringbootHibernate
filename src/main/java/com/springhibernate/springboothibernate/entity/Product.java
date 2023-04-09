package com.springhibernate.springboothibernate.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product_tbl")
public class Product implements Serializable {

    private static final long SERIALIZABLE=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private int id;
    private String name;
    private int quantity;
    private double price;

}
