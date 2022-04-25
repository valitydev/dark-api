package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.FioContent;
import dev.vality.swag.questionary_aggr_proxy.model.Gender;
import org.springframework.stereotype.Component;

@Component
public class FioContentSwagConverter
        implements SwagConverter<FioContent, dev.vality.questionary_proxy_aggr.dadata_fio.FioContent> {

    @Override
    public FioContent toSwag(dev.vality.questionary_proxy_aggr.dadata_fio.FioContent value,
                             SwagConverterContext ctx) {
        FioContent fioContent = new FioContent()
                .name(value.getName())
                .unrestrictedValue(value.getUnrestrictedValue())
                .value(value.getValue())
                .qc((int) value.getQc())
                .patronymic(value.getPatronymic())
                .surname(value.getSurname());
        if (value.isSetGender()) {
            fioContent.setGender(ctx.convert(value.getGender(), Gender.class));
        }

        return fioContent;
    }

}
