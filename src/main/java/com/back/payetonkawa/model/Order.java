package com.back.payetonkawa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {
    @Id
    private int id;

    @ManyToMany
    private List<Product> products;

    @ManyToOne
    private Customer customer;

}
