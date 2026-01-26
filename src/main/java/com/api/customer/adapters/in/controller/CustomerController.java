package com.api.customer.adapters.in.controller;

import com.api.customer.adapters.in.controller.mapper.CustomerMapper;
import com.api.customer.adapters.in.controller.request.CustomerRequest;
import com.api.customer.adapters.in.controller.response.CustomerResponse;
import com.api.customer.application.ports.in.DeleteCustomerByIdInputPort;
import com.api.customer.application.ports.in.FindCustomerByIdInputPort;
import com.api.customer.application.ports.in.InsertCustomerInputPort;
import com.api.customer.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody CustomerRequest customerRequest, @PathVariable String id) {
       var customer = customerMapper.toCustomer(customerRequest);
       customer.setId(id);
       updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
