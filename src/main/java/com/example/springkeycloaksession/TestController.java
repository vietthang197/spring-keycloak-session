package com.example.springkeycloaksession;

import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.ClientAuthorizationContext;
import org.keycloak.authorization.client.representation.TokenIntrospectionResponse;
import org.keycloak.representations.idm.authorization.AuthorizationRequest;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;
import org.keycloak.representations.idm.authorization.Permission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public List<Permission> test(HttpServletRequest httpServletRequest) {
        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) httpServletRequest.getAttribute(KeycloakSecurityContext.class.getName());
        AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
        ClientAuthorizationContext clientContext = ClientAuthorizationContext.class.cast(authzContext);
        AuthzClient authzClient = clientContext.getClient();
        AuthorizationResponse authorizationResponse = authzClient.authorization().authorize(new AuthorizationRequest());

        String rpt = authorizationResponse.getToken();
        TokenIntrospectionResponse requestingPartyToken = authzClient.protection().introspectRequestingPartyToken(rpt);
        return requestingPartyToken.getPermissions();
    }

    @GetMapping("/test")
    @PermitAll
    public List<Permission> test2(HttpServletRequest httpServletRequest) {
        KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) httpServletRequest.getAttribute(KeycloakSecurityContext.class.getName());
        AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
        ClientAuthorizationContext clientContext = ClientAuthorizationContext.class.cast(authzContext);
        AuthzClient authzClient = clientContext.getClient();
        AuthorizationResponse authorizationResponse = authzClient.authorization().authorize(new AuthorizationRequest());

        String rpt = authorizationResponse.getToken();
        TokenIntrospectionResponse requestingPartyToken = authzClient.protection().introspectRequestingPartyToken(rpt);
        return requestingPartyToken.getPermissions();
    }
}
