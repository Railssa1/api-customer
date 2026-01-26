package com.api.customer.application.ports.in;

import com.api.customer.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
