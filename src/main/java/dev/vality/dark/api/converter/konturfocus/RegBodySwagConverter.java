package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.RegBody;
import org.springframework.stereotype.Component;

@Component
public class RegBodySwagConverter
        implements SwagConverter<RegBody, dev.vality.questionary_proxy_aggr.base_kontur_focus.RegBody> {

    @Override
    public RegBody toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.RegBody value,
                          SwagConverterContext ctx) {
        RegBody regBody = new RegBody();
        regBody.setDate(value.getDate());
        regBody.setKpp(value.getKpp());
        regBody.setNalogCode(value.getNalogCode());
        regBody.setNalogName(value.getNalogName());
        regBody.setNalogRegDate(value.getNalogRegDate());
        return regBody;
    }

}
