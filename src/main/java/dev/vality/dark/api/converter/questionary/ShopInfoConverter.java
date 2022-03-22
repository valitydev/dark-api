package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.ShopDetails;
import dev.vality.questionary.ShopInfo;
import dev.vality.questionary.ShopLocation;
import org.springframework.stereotype.Component;

@Component
public class ShopInfoConverter implements
        ThriftConverter<ShopInfo, dev.vality.swag.questionary.model.ShopInfo>,
        SwagConverter<dev.vality.swag.questionary.model.ShopInfo, ShopInfo> {

    @Override
    public dev.vality.swag.questionary.model.ShopInfo toSwag(ShopInfo value, SwagConverterContext ctx) {
        var shopInfo = new dev.vality.swag.questionary.model.ShopInfo();
        if (value.isSetLocation()) {
            shopInfo.setLocation(
                    ctx.convert(value.getLocation(), dev.vality.swag.questionary.model.ShopLocation.class));
        }
        if (value.isSetDetails()) {
            shopInfo.setDetails(ctx.convert(value.getDetails(), dev.vality.swag.questionary.model.ShopDetails.class));
        }
        return shopInfo;
    }

    @Override
    public ShopInfo toThrift(dev.vality.swag.questionary.model.ShopInfo value, ThriftConverterContext ctx) {
        ShopInfo shopInfo = new ShopInfo();
        if (value.getLocation() != null) {
            shopInfo.setLocation(ctx.convert(value.getLocation(), ShopLocation.class));
        }
        if (value.getDetails() != null) {
            shopInfo.setDetails(ctx.convert(value.getDetails(), ShopDetails.class));
        }
        return shopInfo;
    }
}
