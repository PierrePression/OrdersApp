package com.back.payetonkawa.dto;

import com.payetonkafe.entity.model.Product;
import com.payetonkafe.entity.model.Customer;
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
