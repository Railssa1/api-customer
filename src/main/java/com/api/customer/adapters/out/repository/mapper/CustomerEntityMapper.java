package com.api.customer.adapters.out.repository.mapper;

import com.api.customer.adapters.out.repository.entity.CustomerEntity;
import com.api.customer.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

   CustomerEntity toCustomerEntity(Customer customer);
}
