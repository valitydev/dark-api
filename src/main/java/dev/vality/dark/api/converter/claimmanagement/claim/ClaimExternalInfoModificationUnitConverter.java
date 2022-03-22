package dev.vality.dark.api.converter.claimmanagement.claim;

import dev.vality.damsel.claim_management.ExternalInfoModificationUnit;
import dev.vality.dark.api.converter.DarkApiConverter;
import org.springframework.stereotype.Component;

import static dev.vality.swag.claim_management.model.ClaimModificationType.ClaimModificationTypeEnum.EXTERNALINFOMODIFICATIONUNIT;

@Component
public class ClaimExternalInfoModificationUnitConverter implements
        DarkApiConverter<ExternalInfoModificationUnit,
                dev.vality.swag.claim_management.model.ExternalInfoModificationUnit> {

    @Override
    public ExternalInfoModificationUnit convertToThrift(
            dev.vality.swag.claim_management.model.ExternalInfoModificationUnit swagExtInfoModificationUnit
    ) {
        ExternalInfoModificationUnit extInfoModificationUnit = new ExternalInfoModificationUnit();
        extInfoModificationUnit.setDocumentId(swagExtInfoModificationUnit.getDocumentId());
        extInfoModificationUnit.setRoistatId(swagExtInfoModificationUnit.getRoistatId());
        return extInfoModificationUnit;
    }

    @Override
    public dev.vality.swag.claim_management.model.ExternalInfoModificationUnit convertToSwag(
            ExternalInfoModificationUnit extInfoModificationUnit
    ) {
        var swagExtInfoModificationUnit =
                new dev.vality.swag.claim_management.model.ExternalInfoModificationUnit();
        swagExtInfoModificationUnit.setDocumentId(extInfoModificationUnit.getDocumentId());
        swagExtInfoModificationUnit.setRoistatId(extInfoModificationUnit.getRoistatId());
        swagExtInfoModificationUnit.setClaimModificationType(EXTERNALINFOMODIFICATIONUNIT);
        return swagExtInfoModificationUnit;
    }

}
