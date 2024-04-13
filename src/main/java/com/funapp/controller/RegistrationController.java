package com.funapp.controller;

import com.funapp.apimodels.mappers.CustomerRegistrationDataMapper;
import com.funapp.apimodels.request.CustomerRegistrationRequestDTO;
import com.funapp.apimodels.request.SellerRegistrationRequestDTO;
import com.funapp.apimodels.response.CustomerRegistrationResponseDTO;
import com.funapp.apimodels.response.SellerRegistrationResponseDTO;
import com.funapp.service.business.CustomerRegistrationBusinessService;
import com.funapp.service.business.SellerRegistrationBusinessService;
import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import com.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecommerce")
public class RegistrationController {
    private final SellerRegistrationBusinessService sellerRegistrationBusinessService;
    private final CustomerRegistrationBusinessService customerRegistrationBusinessService;
    private final SellerRegistrationDataMapper sellerRegistrationMapper = SellerRegistrationDataMapper.INSTANCE;
    private final CustomerRegistrationDataMapper customerRegistrationDataMapper = CustomerRegistrationDataMapper.INSTANCE;

    @Autowired
    public RegistrationController(
            SellerRegistrationBusinessService sellerRegistrationBusinessService,
            CustomerRegistrationBusinessService customerRegistrationBusinessService ) {
        this.sellerRegistrationBusinessService = sellerRegistrationBusinessService;
        this.customerRegistrationBusinessService = customerRegistrationBusinessService;
    }


    @PostMapping("/seller-registration")
    public ResponseEntity<SellerRegistrationResponseDTO> sellerRegistration(
            @RequestBody SellerRegistrationRequestDTO requestDTO
    ){
        SellerRegistrationInputDTO inputDTO = sellerRegistrationMapper.mapRequestToInput(requestDTO);
        SellerRegistrationOutputDTO outputDTO = sellerRegistrationBusinessService.doProcess(inputDTO);
        SellerRegistrationResponseDTO responseDTO = sellerRegistrationMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
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
