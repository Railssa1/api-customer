package com.api.customer.application.core.usecase;

import com.api.customer.application.core.domain.Customer;
import com.api.customer.application.ports.in.InsertCustomerInputPort;
import com.api.customer.application.ports.out.FindAddressByZipCodeOutputPort;
import com.api.customer.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUsecase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUsecase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }
}
