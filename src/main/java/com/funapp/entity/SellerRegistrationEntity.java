package com.funapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Entity(name = "seller_details_table")
//@Table(name = "seller_details_table")
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
    private Long phoneNumber;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
}
