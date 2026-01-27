package com.api.customer.config;

import com.api.customer.adapters.out.DeleteCustomerByIdAdapter;
import com.api.customer.application.core.usecase.DeleteCustomerByIdUseCase;
import com.api.customer.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase
    ) {
        return new DeleteCustomerByIdUseCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
    }

}
