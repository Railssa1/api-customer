package com.api.customer.adapters.out;

import com.api.customer.adapters.out.repository.CustomerRepository;
import com.api.customer.adapters.out.repository.mapper.CustomerEntityMapper;
import com.api.customer.application.core.domain.Customer;
import com.api.customer.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertCustomerAdapter implements InsertCustomerOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
