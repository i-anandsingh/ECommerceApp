package org.funapp.service.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerRegistrationOutputDTO {
    private String sellerId;
    private String sellerName;
    private String gstNumber;
    private Integer pinCode;
    private String city;
    private String state;
    private String email;
    private Integer phoneNumber;
}
