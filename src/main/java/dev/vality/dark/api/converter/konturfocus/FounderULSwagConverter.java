package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.questionary_proxy_aggr.base_kontur_focus.FounderUL;
import dev.vality.swag.questionary_aggr_proxy.model.FounderUl;
import dev.vality.swag.questionary_aggr_proxy.model.Share;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("AbbreviationAsWordInName")
public class FounderULSwagConverter implements SwagConverter<FounderUl, FounderUL> {

    @Override
    public FounderUl toSwag(FounderUL value, SwagConverterContext ctx) {
        FounderUl founderUl = new FounderUl();
        founderUl.setDate(value.getDate());
        founderUl.setFirstDate(value.getFirstDate());
        founderUl.setInn(value.getInn());
        founderUl.setOgrn(value.getOgrn());
        if (value.isSetShare()) {
            founderUl.setShare(ctx.convert(value.getShare(), Share.class));
        }
        return founderUl;
    }

}
