package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.util.ConverterUtils;
import dev.vality.questionary.LegalEntity;
import dev.vality.swag.questionary.model.*;
import dev.vality.swag.questionary.model.LegalEntity.LegalEntityTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static dev.vality.swag.questionary.model.LegalEntity.LegalEntityTypeEnum.INTERNATIONALLEGALENTITY;
import static dev.vality.swag.questionary.model.LegalEntity.LegalEntityTypeEnum.RUSSIANLEGALENTITY;

@Component
public class LegalEntityConverter implements
        ThriftConverter<LegalEntity, dev.vality.swag.questionary.model.LegalEntity>,
        SwagConverter<dev.vality.swag.questionary.model.LegalEntity, LegalEntity> {

    @Override
    public dev.vality.swag.questionary.model.LegalEntity toSwag(LegalEntity value, SwagConverterContext ctx) {
        if (value.isSetRussianLegalEntity()) {
            RussianLegalEntity russianLegalEntity = new RussianLegalEntity()
                    .additionalSpace(value.getRussianLegalEntity().getAdditionalSpace())
                    .foreignName(value.getRussianLegalEntity().getForeignName())
                    .inn(value.getRussianLegalEntity().getInn())
                    .legalForm(value.getRussianLegalEntity().getLegalForm())
                    .name(value.getRussianLegalEntity().getName())
                    .okatoCode(value.getRussianLegalEntity().getOkatoCode())
                    .okpoCode(value.getRussianLegalEntity().getOkpoCode())
                    .postalAddress(value.getRussianLegalEntity().getPostalAddress())
                    .hasBeneficialOwners(value.getRussianLegalEntity().isHasBeneficialOwners());
            if (value.getRussianLegalEntity().isSetFoundersInfo()) {
                russianLegalEntity.setFoundersInfo(
                        ctx.convert(value.getRussianLegalEntity().getFoundersInfo(), FoundersInfo.class));
            }

            if (value.getRussianLegalEntity().isSetLicenseInfo()) {
                russianLegalEntity
                        .setLicenseInfo(ctx.convert(value.getRussianLegalEntity().getLicenseInfo(), LicenseInfo.class));
            }

            if (value.getRussianLegalEntity().isSetLegalOwnerInfo()) {
                russianLegalEntity.setLegalOwnerInfo(
                        ctx.convert(value.getRussianLegalEntity().getLegalOwnerInfo(), LegalOwnerInfo.class));
            }

            if (value.getRussianLegalEntity().isSetBeneficialOwners()) {
                List<BeneficialOwner> beneficialOwnerList = value.getRussianLegalEntity().getBeneficialOwners().stream()
                        .map(beneficialOwner -> ctx.convert(beneficialOwner, BeneficialOwner.class))
                        .collect(Collectors.toList());
                russianLegalEntity.setBeneficialOwner(beneficialOwnerList);
            }

            if (value.getRussianLegalEntity().isSetPrincipalActivity()) {
                russianLegalEntity.setPrincipalActivity(
                        ctx.convert(value.getRussianLegalEntity().getPrincipalActivity(), Activity.class));
            }

            if (value.getRussianLegalEntity().isSetRegistrationInfo()) {
                russianLegalEntity.setRegistrationInfo(
                        ctx.convert(value.getRussianLegalEntity().getRegistrationInfo(), RegistrationInfo.class));
            }

            if (value.getRussianLegalEntity().isSetResidencyInfo()) {
                russianLegalEntity.setResidencyInfo(
                        ctx.convert(value.getRussianLegalEntity().getResidencyInfo(), ResidencyInfo.class));
            }

            if (value.getRussianLegalEntity().isSetAdditionalInfo()) {
                russianLegalEntity.setAdditionalInfo(
                        ctx.convert(value.getRussianLegalEntity().getAdditionalInfo(), AdditionalInfo.class));
            }

            if (value.getRussianLegalEntity().isSetPropertyInfoDocumentType()) {
                russianLegalEntity.setPropertyInfoDocumentType(
                        ctx.convert(value.getRussianLegalEntity().getPropertyInfoDocumentType(),
                                PropertyInfoDocumentType.class));
            }
            russianLegalEntity.setLegalEntityType(RUSSIANLEGALENTITY);
            return russianLegalEntity;
        } else if (value.isSetInternationalLegalEntity()) {
            var thriftInternationalLegalEntity = value.getInternationalLegalEntity();
            return new InternationalLegalEntity()
                    .legalName(thriftInternationalLegalEntity.getLegalName())
                    .actualAddress(thriftInternationalLegalEntity.getActualAddress())
                    .registeredAddress(thriftInternationalLegalEntity.getRegisteredAddress())
                    .registeredNumber(thriftInternationalLegalEntity.getRegisteredNumber())
                    .tradingName(thriftInternationalLegalEntity.getTradingName())
                    .legalEntityType(INTERNATIONALLEGALENTITY);
        }

        throw new IllegalArgumentException("Unknown legalEntity type: " + value.getClass().getName());
    }

    @Override
    public LegalEntity toThrift(dev.vality.swag.questionary.model.LegalEntity value, ThriftConverterContext ctx) {
        if (value.getLegalEntityType() == LegalEntityTypeEnum.RUSSIANLEGALENTITY) {
            var russianLegalEntity = new dev.vality.questionary.RussianLegalEntity()
                    .setAdditionalSpace(((RussianLegalEntity) value).getAdditionalSpace())
                    .setForeignName(((RussianLegalEntity) value).getForeignName())
                    .setInn(((RussianLegalEntity) value).getInn())
                    .setLegalForm(((RussianLegalEntity) value).getLegalForm())
                    .setName(((RussianLegalEntity) value).getName())
                    .setOkatoCode(((RussianLegalEntity) value).getOkatoCode())
                    .setOkpoCode(((RussianLegalEntity) value).getOkpoCode())
                    .setPostalAddress(((RussianLegalEntity) value).getPostalAddress())
                    .setHasBeneficialOwners(
                            ConverterUtils.safeSetValue(((RussianLegalEntity) value).isHasBeneficialOwners()));
            if (((RussianLegalEntity) value).getFoundersInfo() != null) {
                russianLegalEntity.setFoundersInfo(ctx.convert(((RussianLegalEntity) value).getFoundersInfo(),
                        dev.vality.questionary.FoundersInfo.class));
            }
            if (((RussianLegalEntity) value).getLicenseInfo() != null) {
                russianLegalEntity.setLicenseInfo(ctx.convert(((RussianLegalEntity) value).getLicenseInfo(),
                        dev.vality.questionary.LicenseInfo.class));
            }
            if (((RussianLegalEntity) value).getLegalOwnerInfo() != null) {
                russianLegalEntity.setLegalOwnerInfo(ctx.convert(((RussianLegalEntity) value).getLegalOwnerInfo(),
                        dev.vality.questionary.LegalOwnerInfo.class));
            }
            if (((RussianLegalEntity) value).getBeneficialOwner() != null) {
                List<dev.vality.questionary.BeneficialOwner> beneficialOwnerList =
                        ((RussianLegalEntity) value).getBeneficialOwner().stream()
                                .map(beneficialOwner -> ctx
                                        .convert(beneficialOwner, dev.vality.questionary.BeneficialOwner.class))
                                .collect(Collectors.toList());
                russianLegalEntity.setBeneficialOwners(beneficialOwnerList);
            }
            if (((RussianLegalEntity) value).getPrincipalActivity() != null) {
                russianLegalEntity.setPrincipalActivity(ctx.convert(((RussianLegalEntity) value).getPrincipalActivity(),
                        dev.vality.questionary.Activity.class));
            }
            if (((RussianLegalEntity) value).getRegistrationInfo() != null) {
                russianLegalEntity.setRegistrationInfo(ctx.convert(((RussianLegalEntity) value).getRegistrationInfo(),
                        dev.vality.questionary.RegistrationInfo.class));
            }
            if (((RussianLegalEntity) value).getResidencyInfo() != null) {
                russianLegalEntity.setResidencyInfo(ctx.convert(((RussianLegalEntity) value).getResidencyInfo(),
                        dev.vality.questionary.ResidencyInfo.class));
            }
            if (((RussianLegalEntity) value).getAdditionalInfo() != null) {
                russianLegalEntity.setAdditionalInfo(ctx.convert(((RussianLegalEntity) value).getAdditionalInfo(),
                        dev.vality.questionary.AdditionalInfo.class));
            }
            if (((RussianLegalEntity) value).getPropertyInfoDocumentType() != null) {
                russianLegalEntity.setPropertyInfoDocumentType(
                        ctx.convert(((RussianLegalEntity) value).getPropertyInfoDocumentType(),
                                dev.vality.questionary.PropertyInfoDocumentType.class));
            }

            return LegalEntity.russian_legal_entity(russianLegalEntity);
        } else if (value.getLegalEntityType() == INTERNATIONALLEGALENTITY) {
            InternationalLegalEntity internationalLegalEntity = (InternationalLegalEntity) value;
            var thriftInternationalLegalEntity = new dev.vality.questionary.InternationalLegalEntity()
                    .setLegalName(internationalLegalEntity.getLegalName())
                    .setActualAddress(internationalLegalEntity.getActualAddress())
                    .setRegisteredAddress(internationalLegalEntity.getRegisteredAddress())
                    .setRegisteredNumber(internationalLegalEntity.getRegisteredNumber())
                    .setTradingName(internationalLegalEntity.getTradingName());
            return LegalEntity.international_legal_entity(thriftInternationalLegalEntity);
        }
        throw new IllegalArgumentException("Unknown legalEntity type: " + value.getLegalEntityType());
    }

}
