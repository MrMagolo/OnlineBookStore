package com.onlinebookstore.customerservice.service;

import com.onlinebookstore.customerservice.dto.CustomerDTO;
import com.onlinebookstore.customerservice.dto.UpdateCustomerDTO;
import com.onlinebookstore.customerservice.model.Customer;
import com.onlinebookstore.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO registerCustomer(CustomerDTO createCustomerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(createCustomerDTO.getFirstName());
        customer.setLastName(createCustomerDTO.getLastName());
        customer.setEmail(createCustomerDTO.getEmail());
        customer.setPhone(createCustomerDTO.getPhone());
        customer.setAddress(createCustomerDTO.getAddress());
        customer = customerRepository.save(customer);
        return convertToDTO(customer);
    }

    public CustomerDTO updateCustomer(Long id, UpdateCustomerDTO updateCustomerDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            // Handle customer not found
            return null;
        }
        Customer customer = optionalCustomer.get();
        customer.setFirstName(updateCustomerDTO.getFirstName());
        customer.setLastName(updateCustomerDTO.getLastName());
        customer.setEmail(updateCustomerDTO.getEmail());
        customer.setPhone(updateCustomerDTO.getPhone());
        customer.setAddress(updateCustomerDTO.getAddress());
        customer = customerRepository.save(customer);
        return convertToDTO(customer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.map(this::convertToDTO).orElse(null);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }
}
