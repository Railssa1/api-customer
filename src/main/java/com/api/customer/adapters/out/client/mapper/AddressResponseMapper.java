package com.api.customer.adapters.out.client.mapper;

import com.api.customer.adapters.out.client.response.AddressResponse;
import com.api.customer.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
