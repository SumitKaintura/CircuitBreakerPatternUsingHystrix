package com.niit.MongoDbExample.repo;

import com.niit.MongoDbExample.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {

}
