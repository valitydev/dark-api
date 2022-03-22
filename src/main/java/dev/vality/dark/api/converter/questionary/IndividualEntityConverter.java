package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.IndividualEntity;
import dev.vality.questionary.RussianIndividualEntity;
import dev.vality.swag.questionary.model.IndividualEntity.IndividualEntityTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class IndividualEntityConverter implements
        ThriftConverter<IndividualEntity, dev.vality.swag.questionary.model.IndividualEntity>,
        SwagConverter<dev.vality.swag.questionary.model.IndividualEntity, IndividualEntity> {

    @Override
    public dev.vality.swag.questionary.model.IndividualEntity toSwag(IndividualEntity value,
                                                                       SwagConverterContext ctx) {
        if (value.isSetRussianIndividualEntity()) {
            return ctx.convert(value.getRussianIndividualEntity(),
                    dev.vality.swag.questionary.model.RussianIndividualEntity.class);
        } else {
            throw new IllegalArgumentException("Unknown individualEntity type: " + value.getClass().getName());
        }
    }

    @Override
    public IndividualEntity toThrift(dev.vality.swag.questionary.model.IndividualEntity value,
                                     ThriftConverterContext ctx) {
        IndividualEntity individualEntity = new IndividualEntity();
        if (value.getIndividualEntityType() == IndividualEntityTypeEnum.RUSSIANINDIVIDUALENTITY) {
            individualEntity.setRussianIndividualEntity(ctx.convert(value, RussianIndividualEntity.class));
        } else {
            throw new IllegalArgumentException("Unknown individualEntity type: " + value.getIndividualEntityType());
        }

        return individualEntity;
    }

}
