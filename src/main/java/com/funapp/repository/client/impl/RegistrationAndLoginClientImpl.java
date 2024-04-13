package com.funapp.repository.client.impl;

import com.funapp.apimodels.mappers.CustomerRegistrationDataMapper;
import com.funapp.apimodels.mappers.SellerRegistrationDataMapper;
import com.funapp.repository.CustomerRegistrationRepository;
import com.funapp.repository.client.RegistrationAndLoginClient;
import com.funapp.repository.SellerRegistrationRepository;
import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.request.SellerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import com.funapp.service.models.response.SellerRegistrationOutputDTO;
import com.org.entity.CustomerRegistrationEntity;
import com.org.entity.SellerRegistrationEntity;
import com.org.generator.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegistrationAndLoginClientImpl implements RegistrationAndLoginClient {

    private final CustomerRegistrationRepository customerRegistrationRepository;
    private final SellerRegistrationRepository sellerRegistrationRepository;
    private final SellerRegistrationDataMapper sellerRegistrationDataMapper = SellerRegistrationDataMapper.INSTANCE;
    private final CustomerRegistrationDataMapper customerRegistrationDataMapper = CustomerRegistrationDataMapper.INSTANCE;
    private final IdGenerator idGenerator;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationAndLoginClientImpl (
            CustomerRegistrationRepository customerRegistrationRepository,
            SellerRegistrationRepository sellerRegistrationRepository,
            IdGenerator idGenerator,
            PasswordEncoder passwordEncoder
    ) {
        this.customerRegistrationRepository = customerRegistrationRepository;
        this.sellerRegistrationRepository = sellerRegistrationRepository;
        this.idGenerator = idGenerator;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public CustomerRegistrationOutputDTO saveCustomerData(CustomerRegistrationInputDTO inputDTO) {
        CustomerRegistrationEntity entity = customerRegistrationDataMapper.mapInputToEntity(inputDTO);
        entity.setCustomerId(idGenerator.customerIdGenerator());
        entity.setPassword(passwordEncoder.encode(inputDTO.getPassword()));
        customerRegistrationRepository.save(entity);
        return customerRegistrationDataMapper.mapEntityToOutput(entity);
    }

    @Override
    public SellerRegistrationOutputDTO saveSellerData(SellerRegistrationInputDTO inputDTO) {
        SellerRegistrationEntity entity = sellerRegistrationDataMapper.mapInputToEntity(inputDTO);
        entity.setSellerId(idGenerator.sellerIdGenerator());
        entity.setPassword(passwordEncoder.encode(inputDTO.getPassword()));
        sellerRegistrationRepository.save(entity);
        return sellerRegistrationDataMapper.mapEntityToOutput(entity);
    }
}
