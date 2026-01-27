package com.api.customer.adapters.in.controller.mapper;

import com.api.customer.adapters.in.controller.request.CustomerRequest;
import com.api.customer.adapters.in.controller.response.CustomerResponse;
import com.api.customer.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
