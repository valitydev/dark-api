package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.ShopDetails;
import org.springframework.stereotype.Component;

@Component
public class ShopDetailsConverter implements
        ThriftConverter<ShopDetails, dev.vality.swag.questionary.model.ShopDetails>,
        SwagConverter<dev.vality.swag.questionary.model.ShopDetails, ShopDetails> {

    @Override
    public dev.vality.swag.questionary.model.ShopDetails toSwag(ShopDetails value, SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.ShopDetails()
                .description(value.getDescription())
                .name(value.getName());
    }

    @Override
    public ShopDetails toThrift(dev.vality.swag.questionary.model.ShopDetails value, ThriftConverterContext ctx) {
        return new ShopDetails()
                .setName(value.getName())
                .setDescription(value.getDescription());
    }

}
