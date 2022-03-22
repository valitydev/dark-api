package dev.vality.dark.api.controller;

import dev.vality.dark.api.exceptions.client.NotFoundException;
import dev.vality.dark.api.exceptions.client.badrequest.BadRequestException;
import dev.vality.dark.api.service.KeycloakService;
import dev.vality.dark.api.service.PartyManagementService;
import dev.vality.dark.api.service.QuestionaryService;
import dev.vality.questionary.manage.QuestionaryNotFound;
import dev.vality.questionary.manage.QuestionaryNotValid;
import dev.vality.questionary.manage.QuestionaryVersionConflict;
import dev.vality.swag.questionary.api.QuestionaryApi;
import dev.vality.swag.questionary.model.GeneralError;
import dev.vality.swag.questionary.model.InlineResponse400;
import dev.vality.swag.questionary.model.QuestionaryParams;
import dev.vality.swag.questionary.model.Snapshot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static dev.vality.dark.api.util.ExceptionUtils.darkApi5xxException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionaryController implements QuestionaryApi {

    private final QuestionaryService questionaryService;
    private final PartyManagementService partyManagementService;
    private final KeycloakService keycloakService;

    @Override
    public ResponseEntity<Snapshot> getQuestionary(String questionaryId, @Valid String version) {
        try {
            partyManagementService.checkStatus();

            String partyId = keycloakService.getPartyId();

            Snapshot snapshot = questionaryService.getQuestionary(questionaryId, partyId, version);

            return ResponseEntity.ok(snapshot);
        } catch (QuestionaryNotFound ex) {
            String msg = "Questionary not found";
            GeneralError response = new GeneralError().message(msg);
            throw new NotFoundException(msg, ex, response);
        } catch (TException ex) {
            throw darkApi5xxException("questionary", "getQuestionary", null, ex);
        }
    }

    @Override
    public ResponseEntity<String> saveQuestionary(@Valid QuestionaryParams questionaryParams) {
        try {
            partyManagementService.checkStatus();

            Long ver = questionaryParams.getVersion() != null ? Long.parseLong(questionaryParams.getVersion()) : null;
            String partyId = keycloakService.getPartyId();

            Long version = questionaryService.saveQuestionary(questionaryParams, partyId, ver);
            return ResponseEntity.ok(version.toString());
        } catch (QuestionaryNotValid ex) {
            String msg = "Questionary not valid";
            InlineResponse400 response = new InlineResponse400()
                    .code(InlineResponse400.CodeEnum.QUESTIONARYNOTVALIDEXCEPTION)
                    .message(msg);
            throw new BadRequestException(msg, ex, response);
        } catch (QuestionaryVersionConflict ex) {
            String msg = "Questionary version conflict";
            InlineResponse400 response = new InlineResponse400()
                    .code(InlineResponse400.CodeEnum.QUESTIONARYVERSIONCONFLICT)
                    .message(msg);
            throw new BadRequestException(msg, ex, response);
        } catch (TException ex) {
            throw darkApi5xxException("questionary", "saveQuestionary", null, ex);
        }
    }
}
