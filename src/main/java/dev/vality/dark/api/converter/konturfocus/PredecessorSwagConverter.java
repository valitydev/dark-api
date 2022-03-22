package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Predecessor;
import org.springframework.stereotype.Component;

@Component
public class PredecessorSwagConverter implements
        SwagConverter<Predecessor, dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.Predecessor> {

    @Override
    public Predecessor toSwag(dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.Predecessor value,
                              SwagConverterContext ctx) {
        Predecessor predecessor = new Predecessor();
        predecessor.setDate(value.getDate());
        predecessor.setInn(value.getInn());
        predecessor.setName(value.getName());
        predecessor.setOgrn(value.getOgrn());
        return predecessor;
    }

}
