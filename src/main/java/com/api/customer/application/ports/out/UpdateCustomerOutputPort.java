package com.api.customer.application.ports.out;

import com.api.customer.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
   void update(Customer customer, String zipCode);
}
