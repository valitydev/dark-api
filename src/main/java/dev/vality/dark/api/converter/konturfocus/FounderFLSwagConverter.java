package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.questionary_proxy_aggr.base_kontur_focus.FounderFL;
import dev.vality.swag.questionary_aggr_proxy.model.FounderFl;
import dev.vality.swag.questionary_aggr_proxy.model.Share;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("AbbreviationAsWordInName")
public class FounderFLSwagConverter implements SwagConverter<FounderFl, FounderFL> {

    @Override
    public FounderFl toSwag(FounderFL value, SwagConverterContext ctx) {
        FounderFl founderFl = new FounderFl();
        founderFl.setDate(value.getDate());
        founderFl.setFio(value.getFio());
        founderFl.setFirstDate(value.getFirstDate());
        founderFl.setInnfl(value.getInnfl());
        if (value.isSetShare()) {
            founderFl.setShare(ctx.convert(value.getShare(), Share.class));
        }
        return founderFl;
    }

}
