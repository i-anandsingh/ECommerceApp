package com.funapp.controller;

import com.funapp.apimodels.request.SellerRegistrationRequestDTO;
import com.funapp.apimodels.response.SellerRegistrationResponseDTO;
import com.funapp.service.business.SellerRegistrationBusiness;
import com.funapp.service.models.request.SellerRegistrationInputDTO;
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
public class SellerRegistrationController {
    private final SellerRegistrationBusiness sellerRegistrationBusiness;
    private final SellerRegistrationDataMapper sellerRegistrationMapper = SellerRegistrationDataMapper.INSTANCE;

    @Autowired
    public SellerRegistrationController(SellerRegistrationBusiness sellerRegistrationBusiness) {
        this.sellerRegistrationBusiness = sellerRegistrationBusiness;
    }


    @PostMapping("/seller-registration")
    public ResponseEntity<SellerRegistrationResponseDTO> registerSeller(
            @RequestBody SellerRegistrationRequestDTO requestDTO
    ){
        SellerRegistrationInputDTO inputDTO = sellerRegistrationMapper.mapRequestToInput(requestDTO);
        SellerRegistrationOutputDTO outputDTO = sellerRegistrationBusiness.doProcess(inputDTO);
        SellerRegistrationResponseDTO responseDTO = sellerRegistrationMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
