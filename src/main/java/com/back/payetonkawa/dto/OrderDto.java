package com.back.payetonkawa.dto;

import com.back.payetonkawa.model.Customer;
import com.back.payetonkawa.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderDto {

    private Long id;

    private List<Product> products;

    private Customer customer;
}
