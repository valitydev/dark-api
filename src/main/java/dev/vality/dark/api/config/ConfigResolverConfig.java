package dev.vality.dark.api.config;

import org.apache.commons.lang3.StringUtils;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ConfigResolverConfig {

    @Value("${keycloak.realm}")
    private String keycloakRealmName;

    @Value("${keycloak.resource}")
    private String keycloakResourceName;

    @Value("${keycloak.realm-public-key}")
    private String keycloakRealmPublicKey;

    @Value("${keycloak.realm-public-key.file-path:}")
    private String keycloakRealmPublicKeyFile;

    @Value("${keycloak.auth-server-url}")
    private String keycloakAuthServerUrl;

    @Value("${keycloak.ssl-required}")
    private String keycloakSSLRequired;

    @Value("${keycloak.not-before}")
    private int keycloakTokenNotBefore;

    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return facade -> {
            KeycloakDeployment deployment = KeycloakDeploymentBuilder.build(adapterConfig());
            deployment.setNotBefore(keycloakTokenNotBefore);
            return deployment;
        };
    }

    private AdapterConfig adapterConfig() {
        if (!StringUtils.isBlank(keycloakRealmPublicKeyFile)) {
            keycloakRealmPublicKey = readKeyFromFile(keycloakRealmPublicKeyFile);
        }

        AdapterConfig adapterConfig = new AdapterConfig();
        adapterConfig.setRealm(keycloakRealmName);
        adapterConfig.setRealmKey(keycloakRealmPublicKey);
        adapterConfig.setResource(keycloakResourceName);
        adapterConfig.setAuthServerUrl(keycloakAuthServerUrl);
        adapterConfig.setUseResourceRoleMappings(true);
        adapterConfig.setBearerOnly(true);
        adapterConfig.setSslRequired(keycloakSSLRequired);
        return adapterConfig;
    }

    private String readKeyFromFile(String filePath) {
        try {
            List<String> strings = Files.readAllLines(Paths.get(filePath));
            strings.remove(strings.size() - 1);
            strings.remove(0);

            return strings.stream().map(String::trim).collect(Collectors.joining());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
