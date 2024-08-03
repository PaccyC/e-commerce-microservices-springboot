package com.paccy.ecommerce.customer.service;

import com.paccy.ecommerce.customer.Customer;
import com.paccy.ecommerce.customer.CustomerRequest;
import com.paccy.ecommerce.customer.exceptions.CustomerNotFoundException;
import com.paccy.ecommerce.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        var customer= customerRepository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void editCustomer(CustomerRequest customerRequest) {
        var customer= customerRepository.findById(customerRequest.id()).orElseThrow(
                () -> new CustomerNotFoundException(
                        String.format("Customer with id '%s' not found", HttpStatus.NOT_FOUND)
                )
        );
        mergeCustomer(customer,customerRequest);

        customerRepository.save(customer);

    }

    private void mergeCustomer(Customer customer, CustomerRequest customerRequest) {
        if (StringUtils.isNotBlank(customerRequest.firstName())){
            customer.setFirstName(customerRequest.firstName());
        }
        if (StringUtils.isNotBlank(customerRequest.lastName())){
            customer.setLastName(customerRequest.lastName());
        }
        if (StringUtils.isNotBlank(customerRequest.email())){
            customer.setEmail(customerRequest.email());
        }
        if (customerRequest.address() != null){
            customer.setAddress(customerRequest.address());
        }
    }
}
