package com.paccy.ecommerce.customer.service;

import com.paccy.ecommerce.customer.Customer;
import com.paccy.ecommerce.customer.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {


    public Customer toCustomer(CustomerRequest request) {

        if (request == null) {
            return null;
        }
        return  Customer
                .builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }
}
