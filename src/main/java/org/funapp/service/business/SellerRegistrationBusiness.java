package org.funapp.service.business;

import org.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import org.funapp.entity.SellerRegistrationEntity;
import org.funapp.repository.SellerRegistrationRepository;
import org.funapp.service.models.request.SellerRegistrationInputDTO;
import org.funapp.service.models.response.SellerRegistrationOutputDTO;
import org.funapp.utility.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class SellerRegistrationBusiness {

    @Autowired
    private SellerRegistrationRepository sellerRegistrationRepository;

    @Autowired
    private IdGenerator idGenerator;

    private SellerRegistrationDataMapper sellerRegistrationMapper = SellerRegistrationDataMapper.INSTANCE;

    public SellerRegistrationOutputDTO doProcess(@Valid SellerRegistrationInputDTO inputDTO){
        SellerRegistrationEntity entity = sellerRegistrationMapper.mapInputToEntity(inputDTO);
        entity.setSellerId(idGenerator.sellerIdGenerator());
        sellerRegistrationRepository.save(entity);
        return sellerRegistrationMapper.mapEntityToOutput(entity);
    }
}
