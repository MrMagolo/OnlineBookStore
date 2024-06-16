package com.onlinebookstore.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long orderId;

    private List<BookOrderDTO> books;
    private String status;
    private double totalPrice;
    private String deliveryAddress;
    private String orderDate;
    private Date deliveryDate;
    private  String total;
}
