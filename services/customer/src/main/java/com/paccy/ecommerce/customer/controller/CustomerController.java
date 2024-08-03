package com.paccy.ecommerce.customer.controller;


import com.paccy.ecommerce.customer.Customer;
import com.paccy.ecommerce.customer.CustomerRequest;
import com.paccy.ecommerce.customer.CustomerResponse;
import com.paccy.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest customerRequest
    ){
     return  ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }

    @PutMapping
    public ResponseEntity<Void> editCustomer(
            @RequestBody @Valid CustomerRequest customerRequest
    ){
        customerService.editCustomer(customerRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public  List<CustomerResponse> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/exists/{customer_id}")
    public Boolean existsById(
            @PathVariable String customer_id
    ){
        return  customerService.existsById(customer_id);
    }

    @GetMapping("/{customer_id}")
    public Customer findCustomerById(
            @PathVariable String customer_id
    ){
        return  customerService.findCustomerById(customer_id);
    }

    @DeleteMapping("/{customer_id}")
    public  ResponseEntity<Void> deleteCustomer(
            @PathVariable String customer_id
    ){
        customerService.deleteCustomer(customer_id);
        return  ResponseEntity.accepted().build();
    }
}
