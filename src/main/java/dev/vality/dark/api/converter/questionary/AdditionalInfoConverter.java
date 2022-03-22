package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.util.ConverterUtils;
import dev.vality.questionary.AdditionalInfo;
import dev.vality.swag.questionary.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdditionalInfoConverter implements
        ThriftConverter<AdditionalInfo, dev.vality.swag.questionary.model.AdditionalInfo>,
        SwagConverter<dev.vality.swag.questionary.model.AdditionalInfo, AdditionalInfo> {

    @Override
    public dev.vality.swag.questionary.model.AdditionalInfo toSwag(AdditionalInfo value, SwagConverterContext ctx) {
        var additionalInfo = new dev.vality.swag.questionary.model.AdditionalInfo()
                .staffCount(value.getStaffCount())
                .nkoRelationTarget(value.getNKORelationTarget())
                .relationshipWithNko(value.getRelationshipWithNKO())
                .mainCounterparties(value.getMainCounterparties())
                .benefitThirdParties(value.isBenefitThirdParties())
                .hasBeneficiary(value.isHasBeneficiary())
                .hasLiquidationProcess(value.isHasLiquidationProcess());
        if (value.isSetMonthOperationCount()) {
            additionalInfo
                    .setMonthOperationCount(ctx.convert(value.getMonthOperationCount(), MonthOperationCount.class));
        }
        if (value.isSetMonthOperationSum()) {
            additionalInfo.setMonthOperationSum(ctx.convert(value.getMonthOperationSum(), MonthOperationSum.class));
        }
        if (value.isSetFinancialPosition()) {
            List<FinancialPosition> financialPositionList = value.getFinancialPosition().stream()
                    .map(financialPosition -> ctx.convert(financialPosition, FinancialPosition.class))
                    .collect(Collectors.toList());
            additionalInfo.setFinancialPosition(financialPositionList);
        }
        if (value.isSetBusinessInfo()) {
            List<BusinessInfo> businessInfoList = value.getBusinessInfo().stream()
                    .map(businessInfo -> ctx.convert(businessInfo, BusinessInfo.class))
                    .collect(Collectors.toList());
            additionalInfo.setBusinessInfo(businessInfoList);
        }
        if (value.isSetRelationIndividualEntity()) {
            additionalInfo.setRelationIndividualEntity(
                    ctx.convert(value.getRelationIndividualEntity(), RelationIndividualEntity.class));
        }
        if (value.isSetBusinessReputation()) {
            additionalInfo.setBusinessReputation(ctx.convert(value.getBusinessReputation(), BusinessReputation.class));
        }
        if (value.isSetAccountantInfo()) {
            additionalInfo.setAccountantInfo(ctx.convert(value.getAccountantInfo(), AccountantInfo.class));
        }

        return additionalInfo;
    }

    @Override
    public AdditionalInfo toThrift(dev.vality.swag.questionary.model.AdditionalInfo value,
                                   ThriftConverterContext ctx) {
        AdditionalInfo additionalInfo = new AdditionalInfo()
                .setStaffCount(ConverterUtils.safeSetValue(value.getStaffCount()))
                .setNKORelationTarget(value.getNkoRelationTarget())
                .setRelationshipWithNKO(value.getRelationshipWithNko())
                .setMainCounterparties(value.getMainCounterparties())
                .setBenefitThirdParties(ConverterUtils.safeSetValue(value.isBenefitThirdParties()))
                .setHasBeneficiary(ConverterUtils.safeSetValue(value.isHasBeneficiary()))
                .setHasLiquidationProcess(ConverterUtils.safeSetValue(value.isHasLiquidationProcess()));
        if (value.getMonthOperationCount() != null) {
            additionalInfo.setMonthOperationCount(ctx.convert(value.getMonthOperationCount(),
                    dev.vality.questionary.MonthOperationCount.class));
        }
        if (value.getMonthOperationSum() != null) {
            additionalInfo.setMonthOperationSum(ctx.convert(value.getMonthOperationSum(),
                    dev.vality.questionary.MonthOperationSum.class));
        }
        if (value.getFinancialPosition() != null) {
            List<dev.vality.questionary.FinancialPosition> financialPositionList =
                    value.getFinancialPosition().stream()
                            .map(financialPosition -> ctx
                                    .convert(financialPosition, dev.vality.questionary.FinancialPosition.class))
                            .collect(Collectors.toList());
            additionalInfo.setFinancialPosition(financialPositionList);
        }
        if (value.getBusinessInfo() != null) {
            List<dev.vality.questionary.BusinessInfo> businessInfoList = value.getBusinessInfo().stream()
                    .map(businessInfo -> ctx.convert(businessInfo, dev.vality.questionary.BusinessInfo.class))
                    .collect(Collectors.toList());
            additionalInfo.setBusinessInfo(businessInfoList);
        }
        if (value.getRelationIndividualEntity() != null) {
            additionalInfo.setRelationIndividualEntity(ctx.convert(value.getRelationIndividualEntity(),
                    dev.vality.questionary.RelationIndividualEntity.class));
        }
        if (value.getBusinessReputation() != null) {
            additionalInfo.setBusinessReputation(ctx.convert(value.getBusinessReputation(),
                    dev.vality.questionary.BusinessReputation.class));
        }
        if (value.getAccountantInfo() != null) {
            additionalInfo.setAccountantInfo(ctx.convert(value.getAccountantInfo(),
                    dev.vality.questionary.AccountantInfo.class));
        }

        return additionalInfo;
    }

}
