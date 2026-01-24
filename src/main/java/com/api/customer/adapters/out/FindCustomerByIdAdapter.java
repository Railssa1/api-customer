package com.api.customer.adapters.out;

import com.api.customer.adapters.out.repository.CustomerRepository;
import com.api.customer.adapters.out.repository.mapper.CustomerEntityMapper;
import com.api.customer.application.core.domain.Customer;
import com.api.customer.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customer -> customerEntityMapper.toCustomer(customer));
    }
}
