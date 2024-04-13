package com.funapp.apimodels.mappers;

import com.funapp.apimodels.request.CustomerRegistrationRequestDTO;
import com.funapp.apimodels.response.CustomerRegistrationResponseDTO;
import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import com.org.entity.CustomerRegistrationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface CustomerRegistrationDataMapper {
    CustomerRegistrationDataMapper INSTANCE = Mappers.getMapper(CustomerRegistrationDataMapper.class);
    CustomerRegistrationInputDTO mapRequestToInput (CustomerRegistrationRequestDTO requestDTO);
    CustomerRegistrationResponseDTO mapOutputToResponse(CustomerRegistrationOutputDTO outputDTO);
    CustomerRegistrationEntity mapInputToEntity (CustomerRegistrationInputDTO inputDTO);
    CustomerRegistrationOutputDTO mapEntityToOutput (CustomerRegistrationEntity entity);
}
