package com.back.payetonkawa.repository.impl;

import com.back.payetonkawa.model.Order;
import com.back.payetonkawa.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    public List<Order> getAll(){
        return this.getAll();
    }

    public Order getById(Long id) {
        return this.getById(id);
    }

    public void update(Order oldOrder){
        this.update(oldOrder);
    }

    public void deleteOrder(Long id) {
        this.deleteOrder(id);
    }

    public void createOrder(Order order){
        this.createOrder(order);
    }

}