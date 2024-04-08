package org.funapp.repository;

import org.funapp.entity.SellerRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRegistrationRepository extends JpaRepository<SellerRegistrationEntity, String> {
}
