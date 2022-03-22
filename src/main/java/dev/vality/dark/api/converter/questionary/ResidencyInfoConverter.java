package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.ResidencyInfo;
import dev.vality.swag.questionary.model.IndividualResidencyInfo;
import dev.vality.swag.questionary.model.LegalResidencyInfo;
import dev.vality.swag.questionary.model.ResidencyInfo.ResidencyInfoTypeEnum;
import org.springframework.stereotype.Component;

import static dev.vality.dark.api.util.ConverterUtils.safeSetValue;

@Component
public class ResidencyInfoConverter implements
        ThriftConverter<ResidencyInfo, dev.vality.swag.questionary.model.ResidencyInfo>,
        SwagConverter<dev.vality.swag.questionary.model.ResidencyInfo, ResidencyInfo> {

    @Override
    public dev.vality.swag.questionary.model.ResidencyInfo toSwag(ResidencyInfo value, SwagConverterContext ctx) {
        if (value.isSetIndividualResidencyInfo()) {
            return new IndividualResidencyInfo()
                    .usaTaxResident(value.getIndividualResidencyInfo().isUsaTaxResident())
                    .exceptUsaTaxResident(value.getIndividualResidencyInfo().isExceptUsaTaxResident())
                    .residencyInfoType(ResidencyInfoTypeEnum.INDIVIDUALRESIDENCYINFO);
        } else if (value.isSetLegalResidencyInfo()) {
            return new dev.vality.swag.questionary.model.LegalResidencyInfo()
                    .fatca(value.getLegalResidencyInfo().isFatca())
                    .ownerResident(value.getLegalResidencyInfo().isOwnerResident())
                    .taxResident(value.getLegalResidencyInfo().isTaxResident())
                    .residencyInfoType(ResidencyInfoTypeEnum.LEGALRESIDENCYINFO);
        }

        throw new IllegalArgumentException("Unknown residencyInfo type: " + value.getClass().getName());
    }

    @Override
    public ResidencyInfo toThrift(dev.vality.swag.questionary.model.ResidencyInfo value, ThriftConverterContext ctx) {
        switch (value.getResidencyInfoType()) {
            case INDIVIDUALRESIDENCYINFO:
                var swagIndividualResidencyInfo = (IndividualResidencyInfo) value;
                var individualResidencyInfo = new dev.vality.questionary.IndividualResidencyInfo()
                        .setExceptUsaTaxResident(safeSetValue(swagIndividualResidencyInfo.isExceptUsaTaxResident()))
                        .setUsaTaxResident(safeSetValue(swagIndividualResidencyInfo.isUsaTaxResident()));

                return ResidencyInfo.individual_residency_info(individualResidencyInfo);
            case LEGALRESIDENCYINFO:
                var swagLegalResidencyInfo = (LegalResidencyInfo) value;
                var legalResidencyInfo = new dev.vality.questionary.LegalResidencyInfo()
                        .setTaxResident(safeSetValue(swagLegalResidencyInfo.isTaxResident()))
                        .setOwnerResident(safeSetValue(swagLegalResidencyInfo.isOwnerResident()))
                        .setFatca(safeSetValue(swagLegalResidencyInfo.isFatca()));
                return ResidencyInfo.legal_residency_info(legalResidencyInfo);
            default:
                throw new IllegalArgumentException("Unknown residencyInfo type: " + value.getResidencyInfoType());
        }
    }

}
