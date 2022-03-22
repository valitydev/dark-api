package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.util.ConverterUtils;
import dev.vality.questionary.BeneficialOwner;
import dev.vality.swag.questionary.model.*;
import org.springframework.stereotype.Component;

@Component
public class BeneficialOwnerConverter implements
        ThriftConverter<BeneficialOwner, dev.vality.swag.questionary.model.BeneficialOwner>,
        SwagConverter<dev.vality.swag.questionary.model.BeneficialOwner, BeneficialOwner> {

    @Override
    public dev.vality.swag.questionary.model.BeneficialOwner toSwag(BeneficialOwner value, SwagConverterContext ctx) {
        var beneficialOwner = new dev.vality.swag.questionary.model.BeneficialOwner()
                .inn(value.getInn())
                .pdlCategory(value.isPdlCategory())
                .pdlRelationDegree(value.getPdlRelationDegree())
                .snils(value.getSnils())
                .ownershipPercentage((int) value.getOwnershipPercentage());
        if (value.isSetRussianPrivateEntity()) {
            beneficialOwner
                    .setRussianPrivateEntity(ctx.convert(value.getRussianPrivateEntity(), RussianPrivateEntity.class));
        }
        if (value.isSetIdentityDocument()) {
            beneficialOwner.setIdentityDocument(ctx.convert(value.getIdentityDocument(), IdentityDocument.class));
        }
        if (value.isSetMigrationCardInfo()) {
            beneficialOwner.setMigrationCardInfo(ctx.convert(value.getMigrationCardInfo(), MigrationCardInfo.class));
        }
        if (value.isSetResidenceApprove()) {
            beneficialOwner.setResidenceApprove(ctx.convert(value.getResidenceApprove(), ResidenceApprove.class));
        }
        if (value.isSetResidencyInfo()) {
            beneficialOwner.setResidencyInfo(ctx.convert(value.getResidencyInfo(), ResidencyInfo.class));
        }

        return beneficialOwner;
    }

    @Override
    public BeneficialOwner toThrift(dev.vality.swag.questionary.model.BeneficialOwner value,
                                    ThriftConverterContext ctx) {
        BeneficialOwner beneficialOwner = new BeneficialOwner()
                .setInn(value.getInn())
                .setPdlCategory(ConverterUtils.safeSetValue(value.isPdlCategory()))
                .setPdlRelationDegree(value.getPdlRelationDegree())
                .setSnils(value.getSnils());
        if (value.getOwnershipPercentage() != null) {
            beneficialOwner.setOwnershipPercentage(value.getOwnershipPercentage().byteValue());
        }
        if (value.getRussianPrivateEntity() != null) {
            beneficialOwner.setRussianPrivateEntity(
                    ctx.convert(value.getRussianPrivateEntity(), dev.vality.questionary.RussianPrivateEntity.class));
        }
        if (value.getIdentityDocument() != null) {
            beneficialOwner.setIdentityDocument(
                    ctx.convert(value.getIdentityDocument(), dev.vality.questionary.IdentityDocument.class));
        }
        if (value.getMigrationCardInfo() != null) {
            beneficialOwner.setMigrationCardInfo(
                    ctx.convert(value.getMigrationCardInfo(), dev.vality.questionary.MigrationCardInfo.class));
        }
        if (value.getResidenceApprove() != null) {
            beneficialOwner.setResidenceApprove(
                    ctx.convert(value.getResidenceApprove(), dev.vality.questionary.ResidenceApprove.class));
        }
        if (value.getResidencyInfo() != null) {
            beneficialOwner.setResidencyInfo(
                    ctx.convert(value.getResidencyInfo(), dev.vality.questionary.ResidencyInfo.class));
        }

        return beneficialOwner;
    }

}
