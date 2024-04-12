package com.funapp.repository;

import com.funapp.entity.SellerRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRegistrationRepository extends JpaRepository<SellerRegistrationEntity, String> {
}
