package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.questionary.model.QuestionaryData;
import dev.vality.swag.questionary.model.QuestionaryParams;
import org.springframework.stereotype.Component;

@Component
public class QuestionaryParamsConverter implements
        ThriftConverter<dev.vality.questionary.manage.QuestionaryParams, QuestionaryParams>,
        SwagConverter<QuestionaryParams, dev.vality.questionary.manage.QuestionaryParams> {

    @Override
    public QuestionaryParams toSwag(dev.vality.questionary.manage.QuestionaryParams value, SwagConverterContext ctx) {
        return new QuestionaryParams()
                .id(value.getId())
                .ownerId(value.getOwnerId())
                .data(ctx.convert(value.getData(), QuestionaryData.class));
    }

    @Override
    public dev.vality.questionary.manage.QuestionaryParams toThrift(QuestionaryParams value,
                                                                      ThriftConverterContext ctx) {
        return new dev.vality.questionary.manage.QuestionaryParams()
                .setId(value.getId())
                .setOwnerId(value.getOwnerId())
                .setData(ctx.convert(value.getData(), dev.vality.questionary.manage.QuestionaryData.class));
    }
}
