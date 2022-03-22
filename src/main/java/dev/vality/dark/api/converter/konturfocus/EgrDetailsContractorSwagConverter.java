package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.Contractor;
import dev.vality.swag.questionary_aggr_proxy.model.EgrDetailsContractor;
import dev.vality.swag.questionary_aggr_proxy.model.EgrDetailsIndividualEntity;
import dev.vality.swag.questionary_aggr_proxy.model.EgrDetailsLegalEntity;
import org.springframework.stereotype.Component;

@Component
public class EgrDetailsContractorSwagConverter implements SwagConverter<EgrDetailsContractor, Contractor> {

    @Override
    public EgrDetailsContractor toSwag(Contractor value, SwagConverterContext ctx) {
        if (value.isSetIndividualEntity()) {
            return ctx.convert(value.getIndividualEntity(), EgrDetailsIndividualEntity.class);
        } else if (value.isSetLegalEntity()) {
            return ctx.convert(value.getLegalEntity(), EgrDetailsLegalEntity.class);
        }
        throw new IllegalArgumentException("Need to specify individualEntity/LegalEntity");
    }

}
