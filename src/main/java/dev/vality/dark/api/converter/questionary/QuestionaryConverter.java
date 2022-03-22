package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.manage.Questionary;
import dev.vality.swag.questionary.model.QuestionaryData;
import org.springframework.stereotype.Component;

@Component
public class QuestionaryConverter implements
        ThriftConverter<Questionary, dev.vality.swag.questionary.model.Questionary>,
        SwagConverter<dev.vality.swag.questionary.model.Questionary, Questionary> {

    @Override
    public dev.vality.swag.questionary.model.Questionary toSwag(Questionary value, SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.Questionary()
                .id(value.getId())
                .ownerId(value.getOwnerId())
                .partyId(value.getPartyId())
                .data(ctx.convert(value.getData(), QuestionaryData.class));
    }

    @Override
    public Questionary toThrift(dev.vality.swag.questionary.model.Questionary value, ThriftConverterContext ctx) {
        return new Questionary()
                .setId(value.getId())
                .setOwnerId(value.getOwnerId())
                .setPartyId(value.getPartyId())
                .setData(ctx.convert(value.getData(), dev.vality.questionary.manage.QuestionaryData.class));
    }

}
