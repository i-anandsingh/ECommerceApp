package com.funapp.apimodels.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationResponseDTO {
    private String customerId;
    private String name;
    private int age;
    private Date dob;
}
