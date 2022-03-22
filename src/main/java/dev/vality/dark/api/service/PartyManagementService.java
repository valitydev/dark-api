package dev.vality.dark.api.service;

import dev.vality.damsel.domain.Blocked;
import dev.vality.damsel.domain.PartyStatus;
import dev.vality.damsel.payment_processing.InternalUser;
import dev.vality.damsel.payment_processing.PartyManagementSrv;
import dev.vality.damsel.payment_processing.UserInfo;
import dev.vality.damsel.payment_processing.UserType;
import dev.vality.dark.api.exceptions.client.ForbiddenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static dev.vality.dark.api.util.ExceptionUtils.darkApi5xxException;

@Service
@Slf4j
@RequiredArgsConstructor
@SuppressWarnings("ParameterName")
public class PartyManagementService {

    private final PartyManagementSrv.Iface partyManagementClient;

    private final KeycloakService keycloakService;

    private final UserInfo userInfo = new UserInfo("dark-api", UserType.internal_user(new InternalUser()));

    public void checkStatus() {
        checkStatus(null, keycloakService.getPartyId());
    }

    public void checkStatus(String xRequestId) {
        checkStatus(xRequestId, keycloakService.getPartyId());
    }

    private void checkStatus(String xRequestId, String partyId) {
        log.info("Trying to get request on party-management service for party-status, xRequestId='{}', partyId='{}'",
                xRequestId, partyId);

        PartyStatus status = getPartyStatus(xRequestId, partyId);
        if (status.getBlocking().isSetBlocked()) {
            Blocked blocked = status.getBlocking().getBlocked();
            throw new ForbiddenException(
                    String.format("Party is blocked xRequestId=%s, since=%s, reason=%s",
                            xRequestId, blocked.getSince(), blocked.getReason())
            );
        }

        log.info(
                "Request has been got on party-management service, party-status=unblocked, " +
                        "xRequestId='{}', partyId='{}'", xRequestId, partyId);
    }

    private PartyStatus getPartyStatus(String xRequestId, String partyId) {
        try {
            return partyManagementClient.getStatus(userInfo, partyId);
        } catch (Exception ex) {
            throw darkApi5xxException("party-management", "getStatus", xRequestId, ex);
        }
    }
}
