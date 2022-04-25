package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.NalogRegBody;
import org.springframework.stereotype.Component;

@Component
public class NalogRegBodySwagConverter
        implements SwagConverter<NalogRegBody, dev.vality.questionary_proxy_aggr.base_kontur_focus.NalogRegBody> {

    @Override
    public NalogRegBody toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.NalogRegBody value,
                               SwagConverterContext ctx) {
        NalogRegBody nalogRegBody = new NalogRegBody();
        nalogRegBody.setDate(value.getDate());
        nalogRegBody.setKpp(value.getKpp());
        nalogRegBody.setNalogCode(value.getNalogCode());
        nalogRegBody.setNalogName(value.getNalogName());
        nalogRegBody.setNalogRegDate(value.getNalogRegDate());
        return nalogRegBody;
    }

}
