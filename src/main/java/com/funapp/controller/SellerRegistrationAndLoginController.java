package com.funapp.controller;

import com.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import com.funapp.apimodels.request.SellerRegistrationRequestDTO;
import com.funapp.apimodels.response.SellerRegistrationResponseDTO;
import com.funapp.service.business.SellerRegistrationBusinessService;
import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecommerce")
public class SellerRegistrationAndLoginController {
    private final SellerRegistrationBusinessService sellerRegistrationBusinessService;
    private final SellerRegistrationDataMapper sellerRegistrationMapper = SellerRegistrationDataMapper.INSTANCE;

    @Autowired
    public SellerRegistrationAndLoginController(
            SellerRegistrationBusinessService sellerRegistrationBusinessService ) {
        this.sellerRegistrationBusinessService = sellerRegistrationBusinessService;
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

}
