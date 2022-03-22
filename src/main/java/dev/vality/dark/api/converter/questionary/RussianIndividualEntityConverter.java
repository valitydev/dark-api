package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.util.ConverterUtils;
import dev.vality.questionary.RussianIndividualEntity;
import dev.vality.swag.questionary.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RussianIndividualEntityConverter implements
        ThriftConverter<RussianIndividualEntity, dev.vality.swag.questionary.model.RussianIndividualEntity>,
        SwagConverter<dev.vality.swag.questionary.model.RussianIndividualEntity, RussianIndividualEntity> {

    @Override
    public dev.vality.swag.questionary.model.RussianIndividualEntity toSwag(RussianIndividualEntity value,
                                                                              SwagConverterContext ctx) {
        var russianIndividualEntity = new dev.vality.swag.questionary.model.RussianIndividualEntity()
                .name(value.getName())
                .inn(value.getInn())
                .snils(value.getSnils())
                .hasBeneficialOwners(value.isHasBeneficialOwners())
                .pdlCategory(value.isPdlCategory())
                .pdlRelationDegree(value.getPdlRelationDegree());
        if (value.isSetRegistrationInfo()) {
            russianIndividualEntity
                    .setRegistrationInfo(ctx.convert(value.getRegistrationInfo(), RegistrationInfo.class));
        }
        if (value.isSetIdentityDocument()) {
            russianIndividualEntity
                    .setIdentityDocument(ctx.convert(value.getIdentityDocument(), IdentityDocument.class));
        }
        if (value.isSetLicenseInfo()) {
            russianIndividualEntity.setLicenseInfo(ctx.convert(value.getLicenseInfo(), LicenseInfo.class));
        }
        if (value.isSetMigrationCardInfo()) {
            russianIndividualEntity
                    .setMigrationCardInfo(ctx.convert(value.getMigrationCardInfo(), MigrationCardInfo.class));
        }
        if (value.isSetResidenceApprove()) {
            russianIndividualEntity
                    .setResidenceApprove(ctx.convert(value.getResidenceApprove(), ResidenceApprove.class));
        }
        if (value.isSetIndividualPersonCategories()) {
            russianIndividualEntity.setIndividualPersonCategories(
                    ctx.convert(value.getIndividualPersonCategories(), IndividualPersonCategories.class));
        }
        if (value.isSetResidencyInfo()) {
            russianIndividualEntity.setResidencyInfo(ctx.convert(value.getResidencyInfo(), ResidencyInfo.class));
        }
        if (value.isSetRussianPrivateEntity()) {
            russianIndividualEntity
                    .setRussianPrivateEntity(ctx.convert(value.getRussianPrivateEntity(), RussianPrivateEntity.class));
        }
        if (value.isSetPrincipalActivity()) {
            russianIndividualEntity.setPrincipalActivity(ctx.convert(value.getPrincipalActivity(), Activity.class));
        }
        if (value.isSetAdditionalInfo()) {
            russianIndividualEntity.setAdditionalInfo(ctx.convert(value.getAdditionalInfo(), AdditionalInfo.class));
        }
        if (value.isSetPropertyInfoDocumentType()) {
            russianIndividualEntity.setPropertyInfoDocumentType(
                    ctx.convert(value.getPropertyInfoDocumentType(), PropertyInfoDocumentType.class));
        }
        if (value.isSetBeneficialOwners()) {
            List<BeneficialOwner> beneficialOwnerList = value.getBeneficialOwners().stream()
                    .map(beneficialOwner -> ctx.convert(beneficialOwner, BeneficialOwner.class))
                    .collect(Collectors.toList());
            russianIndividualEntity.setBeneficialOwners(beneficialOwnerList);
        }

        return russianIndividualEntity;
    }

    @Override
    public RussianIndividualEntity toThrift(dev.vality.swag.questionary.model.RussianIndividualEntity value,
                                            ThriftConverterContext ctx) {
        RussianIndividualEntity russianIndividualEntity = new RussianIndividualEntity()
                .setName(value.getName())
                .setInn(value.getInn())
                .setSnils(value.getSnils())
                .setPdlCategory(ConverterUtils.safeSetValue(value.isPdlCategory()))
                .setPdlRelationDegree(value.getPdlRelationDegree())
                .setHasBeneficialOwners(ConverterUtils.safeSetValue(value.isHasBeneficialOwners()));
        if (value.getRegistrationInfo() != null) {
            russianIndividualEntity.setRegistrationInfo(
                    ctx.convert(value.getRegistrationInfo(), dev.vality.questionary.RegistrationInfo.class));
        }
        if (value.getIdentityDocument() != null) {
            russianIndividualEntity.setIdentityDocument(
                    ctx.convert(value.getIdentityDocument(), dev.vality.questionary.IdentityDocument.class));
        }
        if (value.getLicenseInfo() != null) {
            russianIndividualEntity
                    .setLicenseInfo(ctx.convert(value.getLicenseInfo(), dev.vality.questionary.LicenseInfo.class));
        }
        if (value.getMigrationCardInfo() != null) {
            russianIndividualEntity.setMigrationCardInfo(
                    ctx.convert(value.getMigrationCardInfo(), dev.vality.questionary.MigrationCardInfo.class));
        }
        if (value.getResidenceApprove() != null) {
            russianIndividualEntity.setResidenceApprove(
                    ctx.convert(value.getResidenceApprove(), dev.vality.questionary.ResidenceApprove.class));
        }
        if (value.getIndividualPersonCategories() != null) {
            russianIndividualEntity.setIndividualPersonCategories(ctx.convert(value.getIndividualPersonCategories(),
                    dev.vality.questionary.IndividualPersonCategories.class));
        }
        if (value.getResidencyInfo() != null) {
            russianIndividualEntity.setResidencyInfo(
                    ctx.convert(value.getResidencyInfo(), dev.vality.questionary.ResidencyInfo.class));
        }
        if (value.getRussianPrivateEntity() != null) {
            russianIndividualEntity.setRussianPrivateEntity(
                    ctx.convert(value.getRussianPrivateEntity(), dev.vality.questionary.RussianPrivateEntity.class));
        }
        if (value.getPrincipalActivity() != null) {
            russianIndividualEntity.setPrincipalActivity(
                    ctx.convert(value.getPrincipalActivity(), dev.vality.questionary.Activity.class));
        }
        if (value.getAdditionalInfo() != null) {
            russianIndividualEntity.setAdditionalInfo(
                    ctx.convert(value.getAdditionalInfo(), dev.vality.questionary.AdditionalInfo.class));
        }
        if (value.getPropertyInfoDocumentType() != null) {
            russianIndividualEntity.setPropertyInfoDocumentType(
                    ctx.convert(value.getPropertyInfoDocumentType(),
                            dev.vality.questionary.PropertyInfoDocumentType.class));
        }
        if (value.getBeneficialOwners() != null) {
            List<dev.vality.questionary.BeneficialOwner> beneficialOwnerList = value.getBeneficialOwners().stream()
                    .map(beneficialOwner -> ctx
                            .convert(beneficialOwner, dev.vality.questionary.BeneficialOwner.class))
                    .collect(Collectors.toList());
            russianIndividualEntity.setBeneficialOwners(beneficialOwnerList);
        }

        return russianIndividualEntity;
    }

}
