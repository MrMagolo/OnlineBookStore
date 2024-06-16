package com.onlinebookstore.customerservice.dto;

import lombok.Data;

@Data

public class UpdateCustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    // Getters and Setters
}
