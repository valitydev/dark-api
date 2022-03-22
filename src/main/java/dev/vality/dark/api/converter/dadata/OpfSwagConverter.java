package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Opf;
import org.springframework.stereotype.Component;

@Component
public class OpfSwagConverter implements SwagConverter<Opf, dev.vality.questionary_proxy_aggr.base_dadata.Opf> {

    @Override
    public Opf toSwag(dev.vality.questionary_proxy_aggr.base_dadata.Opf value, SwagConverterContext ctx) {
        return new Opf()
                .code(value.getCode())
                .fullName(value.getFullName())
                .shortName(value.getShortName())
                .type(value.getType());
    }

}
