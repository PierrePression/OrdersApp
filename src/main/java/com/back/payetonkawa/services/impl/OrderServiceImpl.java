package com.back.payetonkawa.services.impl;

import com.back.payetonkawa.dto.OrderDto;
import com.back.payetonkawa.mapper.OrderMapper;
import com.back.payetonkawa.model.Order;
import com.back.payetonkawa.repository.OrderRepository;
import com.back.payetonkawa.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderMapper orderMapper;

    @Override
    public List<OrderDto> getAllOrders(){
        List<OrderDto> result = new ArrayList<>();
        this.orderRepository.getAll().forEach(
                elt -> result.add(this.orderMapper.OrderToOrderDto(elt))
        );
        return result;
    }

    @Override
    public OrderDto getbyId(Long id) {
        return this.orderMapper.OrderToOrderDto(this.orderRepository.getById(id));
    }

    @Override
    public OrderDto updateOrder(OrderDto order) {
        Order oldOrder = this.orderRepository.getById(order.getId());

        oldOrder.setCustomer(order.getCustomer());
        oldOrder.setProducts(order.getProducts());

        this.orderRepository.update(oldOrder);

        return this.orderMapper.OrderToOrderDto(oldOrder);
    }

    @Override
    public String deleteOrder(Long id) {
        this.orderRepository.deleteOrder(id);
        return "La commande à bien été suprimée.";
    }

    @Override
    public OrderDto createOrder(OrderDto order) {
        Order newOrder = this.orderMapper.OrderDtoToOrder(order);

        this.orderRepository.createOrder(newOrder);

        return this.orderMapper.OrderToOrderDto(newOrder);
    }
}
