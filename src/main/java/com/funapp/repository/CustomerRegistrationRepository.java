package com.funapp.repository;

import com.org.entity.CustomerRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationEntity, String> {
}
