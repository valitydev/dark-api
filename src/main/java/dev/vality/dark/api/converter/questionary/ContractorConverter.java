package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.Contractor;
import dev.vality.swag.questionary.model.Contractor.ContractorTypeEnum;
import dev.vality.swag.questionary.model.IndividualEntity;
import dev.vality.swag.questionary.model.IndividualEntityContractor;
import dev.vality.swag.questionary.model.LegalEntity;
import dev.vality.swag.questionary.model.LegalEntityContractor;
import org.springframework.stereotype.Component;

@Component
public class ContractorConverter implements
        ThriftConverter<Contractor, dev.vality.swag.questionary.model.Contractor>,
        SwagConverter<dev.vality.swag.questionary.model.Contractor, Contractor> {

    @Override
    public dev.vality.swag.questionary.model.Contractor toSwag(Contractor value, SwagConverterContext ctx) {
        if (value.isSetIndividualEntity()) {
            IndividualEntity individualEntity = ctx.convert(value.getIndividualEntity(), IndividualEntity.class);
            individualEntity.setIndividualEntityType(IndividualEntity.IndividualEntityTypeEnum.RUSSIANINDIVIDUALENTITY);
            return new IndividualEntityContractor().individualEntity(individualEntity)
                    .contractorType(ContractorTypeEnum.INDIVIDUALENTITYCONTRACTOR);
        } else if (value.isSetLegalEntity()) {
            LegalEntity legalEntity = ctx.convert(value.getLegalEntity(), LegalEntity.class);
            return new LegalEntityContractor().legalEntity(legalEntity)
                    .contractorType(ContractorTypeEnum.LEGALENTITYCONTRACTOR);
        } else {
            throw new IllegalArgumentException("Unknown contractor type: " + value.getClass().getName());
        }
    }

    @Override
    public Contractor toThrift(dev.vality.swag.questionary.model.Contractor value, ThriftConverterContext ctx) {
        switch (value.getContractorType()) {
            case INDIVIDUALENTITYCONTRACTOR:
                var individualEntity = ctx.convert(((IndividualEntityContractor) value).getIndividualEntity(),
                        dev.vality.questionary.IndividualEntity.class);
                return Contractor.individual_entity(individualEntity);
            case LEGALENTITYCONTRACTOR:
                var legalEntity = ctx.convert(((LegalEntityContractor) value).getLegalEntity(),
                        dev.vality.questionary.LegalEntity.class);
                return Contractor.legal_entity(legalEntity);
            default:
                throw new IllegalArgumentException("Unknown contractor type: " + value.getContractorType());
        }
    }

}
