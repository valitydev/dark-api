package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.questionary_proxy_aggr.kontur_focus_req.Contractor;
import dev.vality.swag.questionary_aggr_proxy.model.ReqContractor;
import dev.vality.swag.questionary_aggr_proxy.model.ReqIndividualEntity;
import dev.vality.swag.questionary_aggr_proxy.model.ReqLegalEntity;
import org.springframework.stereotype.Component;

@Component
public class ReqContractorSwagConverter implements SwagConverter<ReqContractor, Contractor> {
    @Override
    public ReqContractor toSwag(Contractor value, SwagConverterContext ctx) {
        if (value.isSetIndividualEntity()) {
            return ctx.convert(value.getIndividualEntity(), ReqIndividualEntity.class);
        }
        if (value.isSetLegalEntity()) {
            return ctx.convert(value.getLegalEntity(), ReqLegalEntity.class);
        }
        return null;
    }
}
