package com.funapp.service.business;

import com.funapp.apimodels.mappers.CustomerRegistrationDataMapper;
import com.funapp.repository.CustomerRegistrationRepository;
import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import com.org.entity.CustomerRegistrationEntity;
import com.org.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerRegistrationBusinessService {
    private final CustomerRegistrationRepository customerRegistrationRepository;
    private final IdGenerator idGenerator;
    private final PasswordEncoder passwordEncoder;
    private final CustomerRegistrationDataMapper customerRegistrationDataMapper = CustomerRegistrationDataMapper.INSTANCE;

    @Autowired
    public CustomerRegistrationBusinessService (
            CustomerRegistrationRepository customerRegistrationRepository,
            IdGenerator idGenerator,
            PasswordEncoder passwordEncoder) {
        this.customerRegistrationRepository = customerRegistrationRepository;
        this.idGenerator = idGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    public CustomerRegistrationOutputDTO doProcess(CustomerRegistrationInputDTO inputDTO){
        CustomerRegistrationEntity entity = customerRegistrationDataMapper.mapInputToEntity(inputDTO);
        entity.setCustomerId(idGenerator.customerIdGenerator());
        entity.setPassword(passwordEncoder.encode(inputDTO.getPassword()));
        customerRegistrationRepository.save(entity);
        return customerRegistrationDataMapper.mapEntityToOutput(entity);
    }
}
