package com.api.customer.application.ports.out;

import com.api.customer.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
