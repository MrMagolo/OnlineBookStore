package com.onlinebookstore.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderDTO {

    private String customerId;
    private List<BookOrderDTO> books;
    private String deliveryAddress;
    private String paymentMethod;
    private String total;
}
