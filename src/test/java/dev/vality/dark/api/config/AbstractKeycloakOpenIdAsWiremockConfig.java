package dev.vality.dark.api.config;

import dev.vality.dark.api.DarkApiApplication;
import dev.vality.dark.api.auth.TestRestController;
import dev.vality.dark.api.auth.utils.KeycloakOpenIdStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {DarkApiApplication.class, TestRestController.class},
        properties = {
                "wiremock.server.baseUrl=http://localhost:${wiremock.server.port}",
                "keycloak.auth-server-url=${wiremock.server.baseUrl}/auth"})
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
@ExtendWith(SpringExtension.class)
public abstract class AbstractKeycloakOpenIdAsWiremockConfig {

    @Autowired
    private KeycloakOpenIdStub keycloakOpenIdStub;

    @BeforeAll
    public static void setUp(@Autowired KeycloakOpenIdStub keycloakOpenIdStub) throws Exception {
        keycloakOpenIdStub.givenStub();
    }

    protected String generateJwt(long iat, long exp, String... roles) {
        return keycloakOpenIdStub.generateJwt(iat, exp, roles);
    }

    protected String generateRbkAdminJwt() {
        return keycloakOpenIdStub.generateJwt("RBKadmin");
    }

    protected String generateReadJwt() {
        return keycloakOpenIdStub.generateJwt("party:read");
    }

    protected String generateWriteJwt() {
        return keycloakOpenIdStub.generateJwt("party:write");
    }

    protected String generateInvoicesReadJwt() {
        return keycloakOpenIdStub.generateJwt("invoices:read");
    }
}
