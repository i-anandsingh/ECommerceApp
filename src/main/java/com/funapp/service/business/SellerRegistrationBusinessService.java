package com.funapp.service.business;

import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import com.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import com.funapp.repository.SellerRegistrationRepository;
import com.org.entity.SellerRegistrationEntity;
import com.org.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SellerRegistrationBusinessService {

    private final SellerRegistrationRepository sellerRegistrationRepository;
    private final IdGenerator idGenerator;
    private final PasswordEncoder passwordEncoder;
    private final SellerRegistrationDataMapper sellerRegistrationDataMapper = SellerRegistrationDataMapper.INSTANCE;

    @Autowired
    public SellerRegistrationBusinessService(
            SellerRegistrationRepository sellerRegistrationRepository,
            IdGenerator idGenerator,
            PasswordEncoder passwordEncoder ){
        this.sellerRegistrationRepository = sellerRegistrationRepository;
        this.idGenerator = idGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    public SellerRegistrationOutputDTO doProcess(SellerRegistrationInputDTO inputDTO){
        SellerRegistrationEntity entity = sellerRegistrationDataMapper.mapInputToEntity(inputDTO);
        entity.setSellerId(idGenerator.sellerIdGenerator());
        entity.setPassword(passwordEncoder.encode(inputDTO.getPassword()));
        sellerRegistrationRepository.save(entity);
        return sellerRegistrationDataMapper.mapEntityToOutput(entity);
    }
}
