package com.funapp.service.business;

import com.funapp.apimodels.mappers.CustomerRegistrationDataMapper;
import com.funapp.repository.CustomerRegistrationRepository;
import com.funapp.service.models.request.CustomerRegistrationInputDTO;
import com.funapp.service.models.response.CustomerRegistrationOutputDTO;
import com.org.entity.CustomerRegistrationEntity;
import com.org.generator.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerRegistrationBusinessService {
    private final CustomerRegistrationDataMapper customerRegistrationDataMapper = CustomerRegistrationDataMapper.INSTANCE;
    private final IdGenerator idGenerator;
    private final CustomerRegistrationRepository customerRegistrationRepository;

    @Autowired
    public CustomerRegistrationBusinessService (
            CustomerRegistrationRepository customerRegistrationRepository,
            IdGenerator idGenerator) {
        this.customerRegistrationRepository = customerRegistrationRepository;
        this.idGenerator = idGenerator;
    }

    public CustomerRegistrationOutputDTO doProcess(CustomerRegistrationInputDTO inputDTO){
        CustomerRegistrationEntity entity = customerRegistrationDataMapper.mapInputToEntity(inputDTO);
        entity.setCustomerId(idGenerator.customerIdGenerator());
        customerRegistrationRepository.save(entity);
        return customerRegistrationDataMapper.mapEntityToOutput(entity);
    }
}
