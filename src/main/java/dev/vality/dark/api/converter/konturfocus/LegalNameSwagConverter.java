package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.LegalName;
import org.springframework.stereotype.Component;

@Component
public class LegalNameSwagConverter
        implements SwagConverter<LegalName, dev.vality.questionary_proxy_aggr.base_kontur_focus.LegalName> {

    @Override
    public LegalName toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.LegalName value,
                            SwagConverterContext ctx) {
        LegalName swagLegalName = new LegalName();
        swagLegalName.setDate(value.getDate());
        swagLegalName.setFullName(value.getFullName());
        swagLegalName.setShortName(value.getShortName());
        return swagLegalName;
    }

}
