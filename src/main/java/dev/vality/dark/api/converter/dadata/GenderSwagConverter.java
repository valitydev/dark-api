package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Gender;
import org.springframework.stereotype.Component;

@Component
public class GenderSwagConverter
        implements SwagConverter<Gender, dev.vality.questionary_proxy_aggr.base_dadata.Gender> {

    @Override
    public Gender toSwag(dev.vality.questionary_proxy_aggr.base_dadata.Gender value, SwagConverterContext ctx) {
        if (value == dev.vality.questionary_proxy_aggr.base_dadata.Gender.FEMALE) {
            return Gender.FEMALE;
        } else if (value == dev.vality.questionary_proxy_aggr.base_dadata.Gender.MALE) {
            return Gender.MALE;
        } else if (value == dev.vality.questionary_proxy_aggr.base_dadata.Gender.UNKNOWN) {
            return Gender.UNKNOWN;
        }
        throw new IllegalArgumentException("Unknown gender type: " + value.name());
    }

}
