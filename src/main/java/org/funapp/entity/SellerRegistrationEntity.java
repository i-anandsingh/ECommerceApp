package org.funapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Seller_Details_Table")
public class SellerRegistrationEntity {
    @Id
    @Column(nullable = false)
    private String sellerId;

    @Column(nullable = false)
    private String sellerName;

    @Column(nullable = false)
    private String gstNumber;

    @Column(nullable = false)
    private Integer pinCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer phoneNumber;
}
