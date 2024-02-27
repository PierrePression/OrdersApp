package com.back.payetonkawa.services.impl;

import com.back.payetonkawa.dto.OrderDto;
import com.back.payetonkawa.mapper.OrderMapper;

import com.back.payetonkawa.model.Order;
import com.back.payetonkawa.repository.OrderRepository;
import com.back.payetonkawa.services.OrderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderMapper orderMapper;

    @Override
    public List<OrderDto> getAllOrders(){
        List<OrderDto> result = new ArrayList<>();
        this.orderRepository.findAll().forEach(
                elt -> result.add(this.orderMapper.OrderToOrderDto(elt))
        );
        return result;
    }

    @Override
    public OrderDto getbyId(Long id) {
        return this.orderMapper.OrderToOrderDto(this.orderRepository.findById(id).get());
    }

    @Override
    public OrderDto updateOrder(OrderDto order) {
        Order oldOrder = this.orderRepository.findById(order.getId()).get();

        oldOrder.setCustomer(order.getCustomer());
        oldOrder.setProducts(order.getProducts());

        this.orderRepository.save(oldOrder);

        return this.orderMapper.OrderToOrderDto(oldOrder);
    }

    @Override
    public String deleteOrder(Long id) {
        this.orderRepository.deleteById(id);
        return "La commande à bien été suprimée.";
    }

    @Override
    public OrderDto createOrder(OrderDto order) {
        Order newOrder = this.orderMapper.OrderDtoToOrder(order);

        this.orderRepository.save(newOrder);

        return this.orderMapper.OrderToOrderDto(newOrder);
    }
}
