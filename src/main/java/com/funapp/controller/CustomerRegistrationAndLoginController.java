package com.funapp.controller;

import com.funapp.apimodels.mappers.CustomerRegistrationDataMapper;
import com.funapp.apimodels.request.CustomerRegistrationRequestDTO;
import com.funapp.apimodels.response.CustomerRegistrationResponseDTO;
import com.funapp.service.business.CustomerRegistrationBusinessService;
import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/ecommerce")
@RestController
public class CustomerRegistrationAndLoginController {
    private final CustomerRegistrationBusinessService customerRegistrationBusinessService;
    private final CustomerRegistrationDataMapper customerRegistrationDataMapper = CustomerRegistrationDataMapper.INSTANCE;

    @Autowired
    public CustomerRegistrationAndLoginController (
            CustomerRegistrationBusinessService customerRegistrationBusinessService) {
        this.customerRegistrationBusinessService = customerRegistrationBusinessService;
    }

    @PostMapping("/customer-registration")
    public ResponseEntity<CustomerRegistrationResponseDTO> customerRegistration(
            @RequestBody CustomerRegistrationRequestDTO requestDTO
    ){
        CustomerRegistrationInputDTO inputDTO = customerRegistrationDataMapper.mapRequestToInput(requestDTO);
        CustomerRegistrationOutputDTO outputDTO = customerRegistrationBusinessService.doProcess(inputDTO);
        CustomerRegistrationResponseDTO responseDTO = customerRegistrationDataMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


}
