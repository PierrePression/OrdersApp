package com.back.payetonkawa.services;

import com.back.payetonkawa.dto.OrderDto;
import com.payetonkafe.entity.model.Order;

import java.util.List;


public interface OrderService {

    List<OrderDto> getAllOrders();

    OrderDto getbyId(Long id);

    OrderDto updateOrder(OrderDto order);

    String deleteOrder(Long id);

    OrderDto createOrder(OrderDto order);
}
