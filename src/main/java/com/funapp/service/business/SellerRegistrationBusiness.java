package com.funapp.service.business;

import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import generatorClient.generator.IdGenerator;
import com.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import com.funapp.entity.SellerRegistrationEntity;
import com.funapp.repository.SellerRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public SellerRegistrationOutputDTO doProcess(SellerRegistrationInputDTO inputDTO){
        SellerRegistrationEntity entity = sellerRegistrationDataMapper.mapInputToEntity(inputDTO);
        entity.setSellerId(idGenerator.sellerIdGenerator());
        sellerRegistrationRepository.save(entity);
        return sellerRegistrationDataMapper.mapEntityToOutput(entity);
    }
}
