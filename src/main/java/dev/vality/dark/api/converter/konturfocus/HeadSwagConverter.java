package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Head;
import org.springframework.stereotype.Component;

@Component
public class HeadSwagConverter
        implements SwagConverter<Head, dev.vality.questionary_proxy_aggr.base_kontur_focus.Head> {

    @Override
    public Head toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.Head value, SwagConverterContext ctx) {
        Head head = new Head();
        head.setFio(value.getFio());
        head.setPosition(value.getPosition());
        head.setInnfl(value.getInnfl());
        head.setFirstDate(value.getFirstDate());
        head.setDate(value.getDate());
        return head;
    }

}
