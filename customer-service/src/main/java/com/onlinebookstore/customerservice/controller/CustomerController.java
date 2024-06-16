package com.onlinebookstore.customerservice.controller;

import com.onlinebookstore.customerservice.dto.CustomerDTO;
import com.onlinebookstore.customerservice.dto.UpdateCustomerDTO;
import com.onlinebookstore.customerservice.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ApiOperation(value = "RegisterCustomer")

    public CustomerDTO registerCustomer(@RequestBody CustomerDTO createCustomerDTO) {
        return customerService.registerCustomer(createCustomerDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Customer")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        return customerService.updateCustomer(id, updateCustomerDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieve order details by ID")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
}
