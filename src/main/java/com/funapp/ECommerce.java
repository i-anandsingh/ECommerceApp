package com.funapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.org", "com.funapp" })
public class ECommerce {
    public static void main(String[] args) {
        SpringApplication.run(ECommerce.class, args);
    }
}