package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.LegalAddress;
import dev.vality.swag.questionary_aggr_proxy.model.ParsedAddressRF;
import org.springframework.stereotype.Component;

@Component
public class LegalAddressConverter
        implements SwagConverter<LegalAddress, dev.vality.questionary_proxy_aggr.base_kontur_focus.LegalAddress> {
    @Override
    public LegalAddress toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.LegalAddress value,
                               SwagConverterContext ctx) {
        LegalAddress swagLegalAddress = new LegalAddress();
        if (value.isSetAddressRf()) {
            swagLegalAddress.setAddressRf(ctx.convert(value.getAddressRf(), ParsedAddressRF.class));
        }
        swagLegalAddress.setDate(value.getDate());
        swagLegalAddress.setFirstDate(value.getFirstDate());
        return swagLegalAddress;
    }
}
