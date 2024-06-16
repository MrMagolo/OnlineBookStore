package com.onlinebookstore.orderservice.service;

import com.onlinebookstore.orderservice.dto.CreateOrderDTO;
import com.onlinebookstore.orderservice.dto.OrderDTO;
import com.onlinebookstore.orderservice.dto.UpdateOrderStatusDTO;
import com.onlinebookstore.orderservice.model.Order;
import com.onlinebookstore.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO createOrder(CreateOrderDTO createOrderDTO) {
        Order order = new Order();
        order.setCustomerId(createOrderDTO.getCustomerId());
        order.setTotal(createOrderDTO.getTotal());
        order.setStatus("NEW");
        order = orderRepository.save(order);
        return convertToDTO(order);
    }

    public OrderDTO updateOrderStatus(Long id, UpdateOrderStatusDTO updateOrderStatusDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent()) {
            return null;
        }
        Order order = optionalOrder.get();
        order = orderRepository.save(order);
        return convertToDTO(order);
    }

    public OrderDTO getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.map(this::convertToDTO).orElse(null);
    }

    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotal(order.getOrderNumber());
        return orderDTO;
    }
}
