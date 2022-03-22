package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.RegInfo;
import org.springframework.stereotype.Component;

@Component
public class RegInfoSwagConverter
        implements SwagConverter<RegInfo, dev.vality.questionary_proxy_aggr.base_kontur_focus.RegInfo> {

    @Override
    public RegInfo toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.RegInfo value,
                          SwagConverterContext ctx) {
        RegInfo regInfo = new RegInfo();
        regInfo.setOgrnDate(value.getOgrnDate());
        regInfo.setRegName(value.getRegName());
        return regInfo;
    }

}
