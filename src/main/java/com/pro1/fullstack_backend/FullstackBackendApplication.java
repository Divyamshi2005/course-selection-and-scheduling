package com.pro1.fullstack_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.pro1.fullstack_backend.entity")
@ComponentScan(basePackages = {"com.pro1.fullstack_backend", "com.pro1.config"})  // Ensure to include your config package
public class FullstackBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackBackendApplication.class, args);
    }
}
