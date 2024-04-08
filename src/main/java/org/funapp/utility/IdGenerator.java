package org.funapp.utility;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IdGenerator {
    public String sellerIdGenerator(){
        Random random = new Random();
        Integer id = 10000 + random.nextInt(99999);
        String sellerId = 's' + id.toString();
        return sellerId;
    }
}
