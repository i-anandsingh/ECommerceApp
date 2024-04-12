package org.funapp.service.business;

import generatorClient.generator.IdGenerator;
import org.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import org.funapp.entity.SellerRegistrationEntity;
import org.funapp.repository.SellerRegistrationRepository;
import org.funapp.service.models.request.SellerRegistrationInputDTO;
import org.funapp.service.models.response.SellerRegistrationOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class SellerRegistrationBusiness {

    private final SellerRegistrationRepository sellerRegistrationRepository;
    private final SellerRegistrationDataMapper sellerRegistrationDataMapper = SellerRegistrationDataMapper.INSTANCE;
    private final IdGenerator idGenerator;

    @Autowired
    public SellerRegistrationBusiness(SellerRegistrationRepository sellerRegistrationRepository, IdGenerator idGenerator){
        this.sellerRegistrationRepository = sellerRegistrationRepository;
        this.idGenerator = idGenerator;
    }

    public SellerRegistrationOutputDTO doProcess(@Valid SellerRegistrationInputDTO inputDTO){
        SellerRegistrationEntity entity = sellerRegistrationDataMapper.mapInputToEntity(inputDTO);
        entity.setSellerId(idGenerator.sellerIdGenerator());
        sellerRegistrationRepository.save(entity);
        return sellerRegistrationDataMapper.mapEntityToOutput(entity);
    }
}
