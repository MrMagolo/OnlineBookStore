package com.onlinebookstore.orderservice.dto;

import lombok.Data;

@Data
public class BookOrderDTO {
    private Long bookId;
    private int quantity;
}
