package com.funapp.repository.client;

import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface RegistrationAndLoginClient {
    CustomerRegistrationOutputDTO saveCustomerData(CustomerRegistrationInputDTO inputDTO);
    SellerRegistrationOutputDTO saveSellerData(SellerRegistrationInputDTO inputDTO);
}
