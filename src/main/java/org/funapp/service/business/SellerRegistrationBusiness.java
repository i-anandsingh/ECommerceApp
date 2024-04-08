package org.funapp.service.business;

import org.funapp.service.models.request.SellerRegistrationInputDTO;
import org.funapp.service.models.response.SellerRegistrationOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class SellerRegistrationBusiness {

    public SellerRegistrationOutputDTO doProcess(SellerRegistrationInputDTO inputDTO){
        return new SellerRegistrationOutputDTO();
    }
}
