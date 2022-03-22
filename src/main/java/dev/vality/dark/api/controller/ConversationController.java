package dev.vality.dark.api.controller;

import dev.vality.damsel.messages.ConversationsNotFound;
import dev.vality.damsel.messages.User;
import dev.vality.dark.api.exceptions.client.NotFoundException;
import dev.vality.dark.api.service.ConversationService;
import dev.vality.dark.api.service.KeycloakService;
import dev.vality.dark.api.service.PartyManagementService;
import dev.vality.swag.messages.api.ConversationApi;
import dev.vality.swag.messages.model.ConversationParam;
import dev.vality.swag.messages.model.ConversationResponse;
import dev.vality.swag.messages.model.ConversationStatus;
import dev.vality.swag.messages.model.GeneralError;
import lombok.RequiredArgsConstructor;
import org.apache.thrift.TException;
import org.keycloak.representations.AccessToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static dev.vality.dark.api.util.ExceptionUtils.darkApi5xxException;

@RestController
@RequiredArgsConstructor
public class ConversationController implements ConversationApi {

    private final ConversationService conversationService;
    private final PartyManagementService partyManagementService;
    private final KeycloakService keycloakService;

    @Override
    public ResponseEntity<ConversationResponse> getConversations(@NotNull @Valid List<String> conversationIds,
                                                                 @Valid ConversationStatus conversationStatus) {
        try {
            partyManagementService.checkStatus();

            ConversationResponse conversation =
                    conversationService.getConversation(conversationIds, conversationStatus);

            return ResponseEntity.ok(conversation);
        } catch (ConversationsNotFound ex) {
            throw notFoundException(conversationIds, ex);
        } catch (TException ex) {
            throw darkApi5xxException("swag-messages", "getConversations", null, ex);
        }
    }

    @Override
    public ResponseEntity<Void> saveConversations(@Valid List<ConversationParam> conversationParams) {
        try {
            log.info("Get user accessToken for conversation save");

            partyManagementService.checkStatus();

            AccessToken accessToken = keycloakService.getAccessToken();

            User user = new User()
                    .setUserId(accessToken.getSubject())
                    .setFullname(accessToken.getPreferredUsername())
                    .setEmail(accessToken.getEmail());

            log.info("Save conversation by user: {}", user);

            conversationService.saveConversation(conversationParams, user);

            return ResponseEntity.ok().build();
        } catch (TException ex) {
            throw darkApi5xxException("swag-messages", "saveConversations", null, ex);
        }
    }

    private NotFoundException notFoundException(List<String> conversationIds, ConversationsNotFound ex) {
        String msg = messageConversationsNotFound(conversationIds);
        GeneralError response = new GeneralError();
        response.message(msg);
        return new NotFoundException(msg, ex, response);
    }

    private String messageConversationsNotFound(List<String> conversationIds) {
        return String.format("Conversations not found, claimIds=%s", String.join(", ", conversationIds));
    }
}
