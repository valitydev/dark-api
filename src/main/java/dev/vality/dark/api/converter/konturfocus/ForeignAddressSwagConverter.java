package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.ForeignAddress;
import org.springframework.stereotype.Component;

@Component
public class ForeignAddressSwagConverter
        implements SwagConverter<ForeignAddress, dev.vality.questionary_proxy_aggr.base_kontur_focus.ForeignAddress> {

    @Override
    public ForeignAddress toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.ForeignAddress value,
                                 SwagConverterContext ctx) {
        ForeignAddress swagForeignAddress = new ForeignAddress();
        swagForeignAddress.setAddress(value.getAddress());
        swagForeignAddress.setCountryName(value.getCountryName());
        return swagForeignAddress;
    }

}
