package com.funapp.service.business;

import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import com.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import com.funapp.repository.SellerRegistrationRepository;
import com.org.entity.SellerRegistrationEntity;
import com.org.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SellerRegistrationBusinessService {

    private final SellerRegistrationRepository sellerRegistrationRepository;
    private final SellerRegistrationDataMapper sellerRegistrationDataMapper = SellerRegistrationDataMapper.INSTANCE;
    private final IdGenerator idGenerator;

    @Autowired
    public SellerRegistrationBusinessService(SellerRegistrationRepository sellerRegistrationRepository, IdGenerator idGenerator){
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
