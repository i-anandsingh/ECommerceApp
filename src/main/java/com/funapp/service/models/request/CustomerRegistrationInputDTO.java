package com.funapp.service.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationInputDTO {
    private String customerId;
    private String name;
    private int age;
    private Date dob;
    private Long phoneNumber;
    private String email;
    private String address;
    private int pincode;
    private String state;
    private String city;
}