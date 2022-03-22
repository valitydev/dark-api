package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.util.ConverterUtils;
import dev.vality.swag.questionary.model.*;
import org.springframework.stereotype.Component;

@Component
public class LegalOwnerInfoConverter implements
        ThriftConverter<dev.vality.questionary.LegalOwnerInfo, LegalOwnerInfo>,
        SwagConverter<LegalOwnerInfo, dev.vality.questionary.LegalOwnerInfo> {

    @Override
    public dev.vality.swag.questionary.model.LegalOwnerInfo toSwag(dev.vality.questionary.LegalOwnerInfo value,
                                                                     SwagConverterContext ctx) {
        LegalOwnerInfo legalOwnerInfo = new LegalOwnerInfo()
                .inn(value.getInn())
                .pdlCategory(value.isPdlCategory())
                .pdlRelationDegree(value.getPdlRelationDegree())
                .snils(value.getSnils())
                .termOfOffice(value.getTermOfOffice())
                .headPosition(value.getHeadPosition());
        if (value.isSetIdentityDocument()) {
            legalOwnerInfo.setIdentityDocument(ctx.convert(value.getIdentityDocument(), IdentityDocument.class));
        }
        if (value.isSetResidenceApprove()) {
            legalOwnerInfo.setResidenceApprove(ctx.convert(value.getResidenceApprove(), ResidenceApprove.class));
        }
        if (value.isSetMigrationCardInfo()) {
            legalOwnerInfo.setMigrationCardInfo(ctx.convert(value.getMigrationCardInfo(), MigrationCardInfo.class));
        }
        if (value.isSetRussianPrivateEntity()) {
            legalOwnerInfo
                    .setRussianPrivateEntity(ctx.convert(value.getRussianPrivateEntity(), RussianPrivateEntity.class));
        }
        if (value.isSetAuthorityConfirmingDocument()) {
            legalOwnerInfo.setAuthorityConfirmingDocument(
                    ctx.convert(value.getAuthorityConfirmingDocument(), AuthorityConfirmingDocument.class));
        }

        return legalOwnerInfo;
    }

    @Override
    public dev.vality.questionary.LegalOwnerInfo toThrift(LegalOwnerInfo value, ThriftConverterContext ctx) {
        var legalOwnerInfo = new dev.vality.questionary.LegalOwnerInfo()
                .setInn(value.getInn())
                .setPdlCategory(ConverterUtils.safeSetValue(value.isPdlCategory()))
                .setPdlRelationDegree(value.getPdlRelationDegree())
                .setSnils(value.getSnils())
                .setTermOfOffice(value.getTermOfOffice())
                .setHeadPosition(value.getHeadPosition());
        if (value.getIdentityDocument() != null) {
            legalOwnerInfo.setIdentityDocument(
                    ctx.convert(value.getIdentityDocument(), dev.vality.questionary.IdentityDocument.class));
        }
        if (value.getResidenceApprove() != null) {
            legalOwnerInfo.setResidenceApprove(
                    ctx.convert(value.getResidenceApprove(), dev.vality.questionary.ResidenceApprove.class));
        }
        if (value.getMigrationCardInfo() != null) {
            legalOwnerInfo.setMigrationCardInfo(
                    ctx.convert(value.getMigrationCardInfo(), dev.vality.questionary.MigrationCardInfo.class));
        }
        if (value.getRussianPrivateEntity() != null) {
            legalOwnerInfo.setRussianPrivateEntity(
                    ctx.convert(value.getRussianPrivateEntity(), dev.vality.questionary.RussianPrivateEntity.class));
        }
        if (value.getAuthorityConfirmingDocument() != null) {
            legalOwnerInfo.setAuthorityConfirmingDocument(
                    ctx.convert(value.getAuthorityConfirmingDocument(),
                            dev.vality.questionary.AuthorityConfirmingDocument.class));
        }

        return legalOwnerInfo;

    }

}
