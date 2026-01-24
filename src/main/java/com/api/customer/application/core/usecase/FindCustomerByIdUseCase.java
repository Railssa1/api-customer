package com.api.customer.application.core.usecase;

import com.api.customer.application.core.domain.Customer;
import com.api.customer.application.ports.in.FindCustomerByIdInputPort;
import com.api.customer.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
    @Autowired
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort){
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
      return findCustomerByIdOutputPort.find(id).orElseThrow(() ->
              new RuntimeException("Customer not found"));
    }
}
