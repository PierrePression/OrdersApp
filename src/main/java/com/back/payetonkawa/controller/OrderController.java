package com.back.payetonkawa.controller;

import com.back.payetonkawa.controller.api.OrderApiInterface;
import com.back.payetonkawa.dto.OrderDto;
import com.back.payetonkawa.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/")
@AllArgsConstructor
public class OrderController implements OrderApiInterface {

    private OrderService orderService;

    @GetMapping("getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(this.orderService.getAllOrders());
    }

    @PostMapping("getOrderById")
    public ResponseEntity<OrderDto> getByid(@RequestBody Long id) {
        return ResponseEntity.ok(this.orderService.getbyId(id));
    }

    @PostMapping("updateOrder")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto order) {
        return ResponseEntity.ok(this.orderService.updateOrder(order));

    }

    @PostMapping("deleteOrder")
    public ResponseEntity<String> deleteOrder(@RequestBody Long id) {
        return ResponseEntity.ok(this.orderService.deleteOrder(id));
    }

    @PostMapping("createOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto order) throws Exception {
        return ResponseEntity.ok(this.orderService.createOrder(order));
    }
}
