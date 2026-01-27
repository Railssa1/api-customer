package com.api.customer.application.ports.out;

public interface SendCpfForValidationOutputPort {
    void send(String cpf);
}
