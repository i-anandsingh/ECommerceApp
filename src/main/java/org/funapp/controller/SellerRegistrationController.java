package org.funapp.controller;

import org.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import org.funapp.apimodels.request.SellerRegistrationRequestDTO;
import org.funapp.apimodels.response.SellerRegistrationResponseDTO;
import org.funapp.service.business.SellerRegistrationBusiness;
import org.funapp.service.models.request.SellerRegistrationInputDTO;
import org.funapp.service.models.response.SellerRegistrationOutputDTO;
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

    @Autowired
    private  SellerRegistrationBusiness sellerRegistrationBusiness;
    private SellerRegistrationDataMapper sellerRegistrationMapper = SellerRegistrationDataMapper.INSTANCE;

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
