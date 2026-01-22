package com.api.customer.application.ports.out;

import com.api.customer.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
