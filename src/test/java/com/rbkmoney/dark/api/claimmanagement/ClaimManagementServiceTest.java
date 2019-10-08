package com.rbkmoney.dark.api.claimmanagement;

import com.rbkmoney.damsel.claim_management.*;
import com.rbkmoney.damsel.msgpack.Value;
import com.rbkmoney.dark.api.service.ClaimManagementService;
import com.rbkmoney.swag.claim_management.model.ClaimChangeset;
import com.rbkmoney.swag.claim_management.model.ModificationUnit;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rbkmoney.swag.claim_management.model.ClaimModification.ClaimModificationTypeEnum.DOCUMENTMODIFICATIONUNIT;
import static com.rbkmoney.swag.claim_management.model.DocumentModification.DocumentModificationTypeEnum.DOCUMENTCREATED;
import static com.rbkmoney.swag.claim_management.model.Modification.ModificationTypeEnum.CLAIMMODIFICATION;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimManagementServiceTest {

    @MockBean
    private ClaimManagementSrv.Iface claimManagementClient;

    @Autowired
    private ClaimManagementService claimManagementService;

    @Test
    public void test() throws TException {
        when(claimManagementClient.createClaim(any(String.class), any(ArrayList.class))).thenReturn(getTestCreateClaim());
        when(claimManagementClient.getClaim(any(String.class), any(Long.class))).thenReturn(getTestClaimById());
        when(claimManagementClient.searchClaims(any(ClaimSearchQuery.class))).thenReturn(getTestSearchClaim());

        var requestClaim = claimManagementService.createClaim("test_request_1", getChangeset());
        assertEquals("Swag objects 'Claim' (create) not equals",
                getTestAnswerCreateClaim().toString(), requestClaim.toString());

        var claimById = claimManagementService.getClaimById("test_request_2", 1L);
        assertEquals("Swag objects 'Claim' (by id) not equals",
                getTestAnswerCreateClaim().toString(), claimById.toString());

        List<com.rbkmoney.swag.claim_management.model.Claim> claimList =
                claimManagementService.searchClaims("id", 1, "token", new ArrayList<>());
        assertEquals("Swag objects 'Claim' (search) not equals",
                getTestAnswerCreateClaim().toString(), claimList.get(0).toString());
    }

    public static com.rbkmoney.swag.claim_management.model.Claim getTestAnswerCreateClaim() {
        com.rbkmoney.swag.claim_management.model.Claim testClaim = new com.rbkmoney.swag.claim_management.model.Claim();
        testClaim.setId(1L);
        testClaim.setStatus("accepted");
        testClaim.setCreatedAt(OffsetDateTime.parse("2019-08-21T12:09:32.449571+03:00"));
        testClaim.setRevision(1);
        testClaim.setUpdatedAt(OffsetDateTime.parse("2019-08-21T12:09:32.449571+03:00"));
        testClaim.setChangeset(getChangeset());
        Map<String, Value> claimMetadata = new HashMap<>();
        claimMetadata.put("test_key", new Value());
        testClaim.setMetadata(claimMetadata);
        return testClaim;
    }

    public static ClaimChangeset getChangeset() {
        ClaimChangeset changeset = new ClaimChangeset();
        ModificationUnit modificationUnit = new ModificationUnit();
        modificationUnit.setModificationID(1L);
        modificationUnit.setCreatedAt(OffsetDateTime.parse("2019-08-21T12:09:32.449571+03:00"));
        var documentModificationUnit = new com.rbkmoney.swag.claim_management.model.DocumentModificationUnit();
        documentModificationUnit.setModificationType(CLAIMMODIFICATION);
        documentModificationUnit.setClaimModificationType(DOCUMENTMODIFICATIONUNIT);
        documentModificationUnit.setId("id_1");
        //TODO: посмотреть на вопрос вложенности. Возможно могуть быть проблемы с этим
        //var documentCreated = new com.rbkmoney.swag.claim_management.model.DocumentCreated();
        var documentModification = new com.rbkmoney.swag.claim_management.model.DocumentModification();
        documentModification.setDocumentModificationType(DOCUMENTCREATED);
        //documentCreated.setDocumentModificationType(DOCUMENTCREATED);
        documentModificationUnit.setModification(documentModification);
        modificationUnit.setModification(documentModificationUnit);

        changeset.add(modificationUnit);
        return changeset;
    }

    private static Claim getTestCreateClaim() {
        Claim claim = new Claim();
        claim.setCreatedAt("2019-08-21T12:09:32.449571+03:00");
        claim.setId(1L);
        claim.setRevision(1);
        claim.setStatus(ClaimStatus.accepted(new ClaimAccepted()));
        Map<String, Value> claimMetadata = new HashMap<>();
        claimMetadata.put("test_key", new Value());
        claim.setMetadata(claimMetadata);
        claim.setUpdatedAt("2019-08-21T12:09:32.449571+03:00");
        List<com.rbkmoney.damsel.claim_management.ModificationUnit> changeset = new ArrayList<>();
        DocumentModification documentModification = new DocumentModification();
        documentModification.setCreation(new DocumentCreated());

        ClaimModification claimModification = new ClaimModification();
        claimModification.setDocumentModification(new DocumentModificationUnit()
                .setId("id_1")
                .setModification(documentModification));
        com.rbkmoney.damsel.claim_management.Modification modification = new com.rbkmoney.damsel.claim_management.Modification();
        modification.setClaimModfication(claimModification);
        var thriftModificationUnit = new com.rbkmoney.damsel.claim_management.ModificationUnit();
        thriftModificationUnit.setCreatedAt("2019-08-21T12:09:32.449571+03:00");
        thriftModificationUnit.setModificationId(1L);
        thriftModificationUnit.setModification(modification);
        changeset.add(thriftModificationUnit);
        claim.setChangeset(changeset);
        return claim;
    }

    private static Claim getTestClaimById() {
        return getTestCreateClaim();
    }

    private static List<Claim> getTestSearchClaim() {
        List<Claim> claimList = new ArrayList<>();
        claimList.add(getTestCreateClaim());
        return claimList;
    }

}