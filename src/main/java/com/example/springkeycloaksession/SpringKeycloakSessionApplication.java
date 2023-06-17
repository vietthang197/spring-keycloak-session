package com.example.springkeycloaksession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringKeycloakSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKeycloakSessionApplication.class, args);
    }

}
