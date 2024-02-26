package com.back.payetonkawa.repository;

import com.back.payetonkawa.model.Order;

import java.util.List;

public interface OrderRepository {

    public List<Order> getAll();

    public Order getById(Long id);

    public void update(Order oldOrder);

    public void deleteOrder(Long id);

    public void createOrder(Order order);
}
