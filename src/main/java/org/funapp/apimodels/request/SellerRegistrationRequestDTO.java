package org.funapp.apimodels.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerRegistrationRequestDTO {
    private String sellerName;
    private String gstNumber;
    private Integer pinCode;
    private String city;
    private String state;
    private String email;
    private Integer phoneNumber;

}
