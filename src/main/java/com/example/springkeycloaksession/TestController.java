package com.example.springkeycloaksession;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public String test(HttpServletRequest httpServletRequest) {
        return "OK";
    }
}
