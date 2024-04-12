package org.funapp.apimodels.mappers;

import javax.annotation.processing.Generated;
import org.funapp.apimodels.request.SellerRegistrationRequestDTO;
import org.funapp.apimodels.response.SellerRegistrationResponseDTO;
import org.funapp.entity.SellerRegistrationEntity;
import org.funapp.service.models.request.SellerRegistrationInputDTO;
import org.funapp.service.models.response.SellerRegistrationOutputDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T10:54:13+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
public class SellerRegistrationDataMapperImpl implements SellerRegistrationDataMapper {

    @Override
    public SellerRegistrationInputDTO mapRequestToInput(SellerRegistrationRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        SellerRegistrationInputDTO.SellerRegistrationInputDTOBuilder sellerRegistrationInputDTO = SellerRegistrationInputDTO.builder();

        sellerRegistrationInputDTO.sellerName( requestDTO.getSellerName() );
        sellerRegistrationInputDTO.gstNumber( requestDTO.getGstNumber() );
        sellerRegistrationInputDTO.pinCode( requestDTO.getPinCode() );
        sellerRegistrationInputDTO.city( requestDTO.getCity() );
        sellerRegistrationInputDTO.state( requestDTO.getState() );
        sellerRegistrationInputDTO.email( requestDTO.getEmail() );
        sellerRegistrationInputDTO.phoneNumber( requestDTO.getPhoneNumber() );

        return sellerRegistrationInputDTO.build();
    }

    @Override
    public SellerRegistrationEntity mapInputToEntity(SellerRegistrationInputDTO inputDTO) {
        if ( inputDTO == null ) {
            return null;
        }

        SellerRegistrationEntity sellerRegistrationEntity = new SellerRegistrationEntity();

        sellerRegistrationEntity.setSellerName( inputDTO.getSellerName() );
        sellerRegistrationEntity.setGstNumber( inputDTO.getGstNumber() );
        sellerRegistrationEntity.setPinCode( inputDTO.getPinCode() );
        sellerRegistrationEntity.setCity( inputDTO.getCity() );
        sellerRegistrationEntity.setState( inputDTO.getState() );
        sellerRegistrationEntity.setEmail( inputDTO.getEmail() );
        sellerRegistrationEntity.setPhoneNumber( inputDTO.getPhoneNumber() );

        return sellerRegistrationEntity;
    }

    @Override
    public SellerRegistrationOutputDTO mapEntityToOutput(SellerRegistrationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SellerRegistrationOutputDTO.SellerRegistrationOutputDTOBuilder sellerRegistrationOutputDTO = SellerRegistrationOutputDTO.builder();

        sellerRegistrationOutputDTO.sellerId( entity.getSellerId() );
        sellerRegistrationOutputDTO.sellerName( entity.getSellerName() );
        sellerRegistrationOutputDTO.gstNumber( entity.getGstNumber() );
        sellerRegistrationOutputDTO.pinCode( entity.getPinCode() );
        sellerRegistrationOutputDTO.city( entity.getCity() );
        sellerRegistrationOutputDTO.state( entity.getState() );
        sellerRegistrationOutputDTO.email( entity.getEmail() );
        sellerRegistrationOutputDTO.phoneNumber( entity.getPhoneNumber() );

        return sellerRegistrationOutputDTO.build();
    }

    @Override
    public SellerRegistrationResponseDTO mapOutputToResponse(SellerRegistrationOutputDTO outputDTO) {
        if ( outputDTO == null ) {
            return null;
        }

        SellerRegistrationResponseDTO.SellerRegistrationResponseDTOBuilder sellerRegistrationResponseDTO = SellerRegistrationResponseDTO.builder();

        sellerRegistrationResponseDTO.sellerId( outputDTO.getSellerId() );
        sellerRegistrationResponseDTO.sellerName( outputDTO.getSellerName() );
        sellerRegistrationResponseDTO.gstNumber( outputDTO.getGstNumber() );
        sellerRegistrationResponseDTO.pinCode( outputDTO.getPinCode() );
        sellerRegistrationResponseDTO.city( outputDTO.getCity() );
        sellerRegistrationResponseDTO.state( outputDTO.getState() );
        sellerRegistrationResponseDTO.email( outputDTO.getEmail() );
        sellerRegistrationResponseDTO.phoneNumber( outputDTO.getPhoneNumber() );

        return sellerRegistrationResponseDTO.build();
    }
}
