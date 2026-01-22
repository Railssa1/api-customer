package com.api.customer.application.ports.in;

import com.api.customer.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);
}
