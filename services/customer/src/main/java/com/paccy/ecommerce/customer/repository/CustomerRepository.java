package com.paccy.ecommerce.customer.repository;

import com.paccy.ecommerce.customer.Customer;
import com.paccy.ecommerce.customer.CustomerRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

}
