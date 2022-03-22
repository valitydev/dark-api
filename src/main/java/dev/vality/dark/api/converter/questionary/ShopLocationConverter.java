package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.ShopLocation;
import dev.vality.swag.questionary.model.ShopLocation.LocationTypeEnum;
import dev.vality.swag.questionary.model.ShopLocationUrl;
import org.springframework.stereotype.Component;

@Component
public class ShopLocationConverter implements
        ThriftConverter<ShopLocation, dev.vality.swag.questionary.model.ShopLocation>,
        SwagConverter<dev.vality.swag.questionary.model.ShopLocation, ShopLocation> {

    @Override
    public dev.vality.swag.questionary.model.ShopLocation toSwag(ShopLocation value, SwagConverterContext ctx) {
        return new ShopLocationUrl()
                .url(value.getUrl())
                .locationType(LocationTypeEnum.SHOPLOCATIONURL);
    }

    @Override
    public ShopLocation toThrift(dev.vality.swag.questionary.model.ShopLocation value, ThriftConverterContext ctx) {
        ShopLocation shopLocation = new ShopLocation();
        if (value.getLocationType() == LocationTypeEnum.SHOPLOCATIONURL) {
            shopLocation.setUrl(((ShopLocationUrl) value).getUrl());
            return shopLocation;
        }
        throw new IllegalArgumentException("Unknown shopLocation type: " + shopLocation);
    }

}
