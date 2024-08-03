package com.paccy.ecommerce.customer.controller;


import com.paccy.ecommerce.customer.CustomerRequest;
import com.paccy.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
