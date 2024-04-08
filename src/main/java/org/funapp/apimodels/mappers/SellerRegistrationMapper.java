package org.funapp.apimodels.mappers;

import org.funapp.apimodels.request.SellerRegistrationRequestDTO;
import org.funapp.service.models.request.SellerRegistrationInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellerRegistrationMapper {
    SellerRegistrationMapper INSTANCE = Mappers.getMapper(SellerRegistrationMapper.class);
    SellerRegistrationInputDTO mapRequestToInput(SellerRegistrationRequestDTO requestDTO);
}
