package com.funapp.service.business;

import com.funapp.repository.client.impl.RegistrationAndLoginClientImpl;
import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerRegistrationBusinessService {
    private final RegistrationAndLoginClientImpl registrationAndLoginClientImpl;

    @Autowired
    public CustomerRegistrationBusinessService (
            RegistrationAndLoginClientImpl registrationAndLoginClientImpl
    ) {
        this.registrationAndLoginClientImpl = registrationAndLoginClientImpl;
    }

    public CustomerRegistrationOutputDTO doProcess(CustomerRegistrationInputDTO inputDTO){
        return registrationAndLoginClientImpl.saveCustomerData(inputDTO);
    }
}
