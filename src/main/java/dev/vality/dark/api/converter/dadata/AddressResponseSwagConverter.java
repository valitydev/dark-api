package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.AddressResponse;
import dev.vality.swag.questionary_aggr_proxy.model.DaDataAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressResponseSwagConverter
        implements SwagConverter<AddressResponse, dev.vality.questionary_proxy_aggr.dadata_address.AddressResponse> {

    @Override
    public AddressResponse toSwag(dev.vality.questionary_proxy_aggr.dadata_address.AddressResponse value,
                                  SwagConverterContext ctx) {
        AddressResponse addressResponse = new AddressResponse();
        if (value.isSetSuggestions()) {
            List<DaDataAddress> daDataAddressList = value.getSuggestions().stream()
                    .map(address -> ctx.convert(address, DaDataAddress.class))
                    .collect(Collectors.toList());
            addressResponse.setSuggestions(daDataAddressList);
        }
        addressResponse.setDaDataResponseType(addressResponse.getClass().getSimpleName());
        return addressResponse;
    }

}
