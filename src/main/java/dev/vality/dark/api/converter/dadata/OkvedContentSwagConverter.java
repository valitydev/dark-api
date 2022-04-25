package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.OkvedContent;
import org.springframework.stereotype.Component;

@Component
public class OkvedContentSwagConverter
        implements SwagConverter<OkvedContent, dev.vality.questionary_proxy_aggr.dadata_okved2.OkvedContent> {

    @Override
    public OkvedContent toSwag(dev.vality.questionary_proxy_aggr.dadata_okved2.OkvedContent value,
                               SwagConverterContext ctx) {
        return new OkvedContent()
                .code(value.getCode())
                .idx(value.getIdx())
                .name(value.getName())
                .section(value.getSection())
                .value(value.getValue());
    }

}
