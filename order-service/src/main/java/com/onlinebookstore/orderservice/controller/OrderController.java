package com.onlinebookstore.orderservice.controller;

import com.onlinebookstore.orderservice.dto.CreateOrderDTO;
import com.onlinebookstore.orderservice.dto.OrderDTO;
import com.onlinebookstore.orderservice.dto.UpdateOrderStatusDTO;
import com.onlinebookstore.orderservice.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ApiOperation(value = "create ORDER")
    public OrderDTO createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        return orderService.createOrder(createOrderDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "UPDATE ORDER STATUS")
    public OrderDTO updateOrderStatus(@PathVariable Long id, @RequestBody UpdateOrderStatusDTO updateOrderStatusDTO) {
        return orderService.updateOrderStatus(id, updateOrderStatusDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "GET ORDER BY ID")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/customers/{customerId}/orders")
    @ApiOperation(value = "List all orders for a specific customer by customer ID")
    public List<OrderDTO> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }
}

