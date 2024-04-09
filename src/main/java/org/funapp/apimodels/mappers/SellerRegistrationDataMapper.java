package org.funapp.apimodels.mappers;

import org.funapp.apimodels.request.SellerRegistrationRequestDTO;
import org.funapp.apimodels.response.SellerRegistrationResponseDTO;
import org.funapp.entity.SellerRegistrationEntity;
import org.funapp.service.models.request.SellerRegistrationInputDTO;
import org.funapp.service.models.response.SellerRegistrationOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SellerRegistrationDataMapper {
    SellerRegistrationDataMapper INSTANCE = Mappers.getMapper(SellerRegistrationDataMapper.class);
    SellerRegistrationInputDTO mapRequestToInput(SellerRegistrationRequestDTO requestDTO);
    @Mapping(target = "sellerId", ignore = true)
    SellerRegistrationEntity mapInputToEntity(SellerRegistrationInputDTO inputDTO);
    SellerRegistrationOutputDTO mapEntityToOutput(SellerRegistrationEntity entity);
    SellerRegistrationResponseDTO mapOutputToResponse(SellerRegistrationOutputDTO outputDTO);
}
