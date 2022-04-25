package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.questionary_proxy_aggr.base_dadata.FounderType;
import dev.vality.swag.questionary_aggr_proxy.model.DaDataHID;
import dev.vality.swag.questionary_aggr_proxy.model.Founder;
import org.springframework.stereotype.Component;

@Component
public class FounderSwagConverter
        implements SwagConverter<Founder, dev.vality.questionary_proxy_aggr.base_dadata.Founder> {

    @Override
    public Founder toSwag(dev.vality.questionary_proxy_aggr.base_dadata.Founder value, SwagConverterContext ctx) {
        Founder founder = new Founder()
                .fio(value.getFio())
                .hid(new DaDataHID().hid(value.getHid()))
                .inn(value.getInn())
                .name(value.getName())
                .ogrn(value.getOgrn());
        if (value.getType() == FounderType.LEGAL) {
            founder.setType(dev.vality.swag.questionary_aggr_proxy.model.FounderType.LEGAL);
        } else if (value.getType() == FounderType.PHYSICAL) {
            founder.setType(dev.vality.swag.questionary_aggr_proxy.model.FounderType.PHYSICAL);
        }

        return founder;
    }

}
