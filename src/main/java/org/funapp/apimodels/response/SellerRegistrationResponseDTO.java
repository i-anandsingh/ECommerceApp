package org.funapp.apimodels.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SellerRegistrationResponseDTO {
    private String sellerId;
    private String sellerName;
    private String gstNumber;
    private Integer pinCode;
    private String city;
    private String state;
    private String email;
    private Long phoneNumber;
}
