package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Toponim;
import org.springframework.stereotype.Component;

@Component
public class ToponimConverterSwagConverter
        implements SwagConverter<Toponim, dev.vality.questionary_proxy_aggr.base_kontur_focus.Toponim> {

    @Override
    public Toponim toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.Toponim value,
                          SwagConverterContext ctx) {
        return new Toponim()
                .topoValue(value.getTopoValue())
                .topoFullName(value.getTopoFullName())
                .topoShortName(value.getTopoShortName());
    }

}
