package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.RelationIndividualEntity;
import org.springframework.stereotype.Component;

@Component
public class RelationIndividualEntityConverter implements
        ThriftConverter<RelationIndividualEntity, dev.vality.swag.questionary.model.RelationIndividualEntity>,
        SwagConverter<dev.vality.swag.questionary.model.RelationIndividualEntity, RelationIndividualEntity> {

    @Override
    public dev.vality.swag.questionary.model.RelationIndividualEntity toSwag(RelationIndividualEntity value,
                                                                               SwagConverterContext ctx) {
        switch (value) {
            case liquidation_process:
                return dev.vality.swag.questionary.model.RelationIndividualEntity.LIQUIDATIONPROCESS;
            case insolvency_proceedings:
                return dev.vality.swag.questionary.model.RelationIndividualEntity.INSOLVENCYPROCEEDINGS;
            case bankrupt_judicial_decision:
                return dev.vality.swag.questionary.model.RelationIndividualEntity.BANKRUPTJUDICIALDECISION;
            default:
                throw new IllegalArgumentException("Unknown relationIndividualEntity type: " + value);
        }
    }

    @Override
    public RelationIndividualEntity toThrift(dev.vality.swag.questionary.model.RelationIndividualEntity value,
                                             ThriftConverterContext ctx) {
        switch (value) {
            case LIQUIDATIONPROCESS:
                return RelationIndividualEntity.liquidation_process;
            case INSOLVENCYPROCEEDINGS:
                return RelationIndividualEntity.insolvency_proceedings;
            case BANKRUPTJUDICIALDECISION:
                return RelationIndividualEntity.bankrupt_judicial_decision;
            default:
                throw new IllegalArgumentException("Unknown relationIndividualEntity type: " + value);
        }
    }

}
