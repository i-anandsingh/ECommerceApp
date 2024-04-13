package com.funapp.service.business;

import com.funapp.repository.client.impl.RegistrationAndLoginClientImpl;
import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SellerRegistrationBusinessService {
    private RegistrationAndLoginClientImpl registrationAndLoginClientImpl;

    @Autowired
    public SellerRegistrationBusinessService(
            RegistrationAndLoginClientImpl registrationAndLoginClientImpl
    ){
        this.registrationAndLoginClientImpl = registrationAndLoginClientImpl;
    }

    public SellerRegistrationOutputDTO doProcess(SellerRegistrationInputDTO inputDTO){
        return registrationAndLoginClientImpl.saveSellerData(inputDTO);
    }
}
