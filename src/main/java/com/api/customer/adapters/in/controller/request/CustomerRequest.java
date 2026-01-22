package com.api.customer.adapters.in.controller.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String cpf;
    private String zipCode;
}
