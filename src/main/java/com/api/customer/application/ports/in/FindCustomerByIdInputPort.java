package com.api.customer.application.ports.in;

import com.api.customer.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
