package com.api.customer.application.core.usecase;

import com.api.customer.application.ports.in.FindCustomerByIdInputPort;
import com.api.customer.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteCustomerByIdUseCase {

    @Autowired
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    @Autowired
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    DeleteCustomerByIdUseCase(DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort){
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
