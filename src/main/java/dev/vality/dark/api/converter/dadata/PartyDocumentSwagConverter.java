package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.IFNCRegistration;
import dev.vality.swag.questionary_aggr_proxy.model.PartyDocuments;
import org.springframework.stereotype.Component;

@Component
public class PartyDocumentSwagConverter
        implements SwagConverter<PartyDocuments, dev.vality.questionary_proxy_aggr.dadata_party.PartyDocuments> {

    @Override
    public PartyDocuments toSwag(dev.vality.questionary_proxy_aggr.dadata_party.PartyDocuments value,
                                 SwagConverterContext ctx) {
        PartyDocuments partyDocuments = new PartyDocuments();
        if (value.isSetFtsRegistration()) {
            partyDocuments.setFtsRegistration(ctx.convert(value.getFtsRegistration(), IFNCRegistration.class));
        }
        if (value.isSetPfRegistration()) {
            partyDocuments.setPfRegistration(ctx.convert(value.getPfRegistration(), IFNCRegistration.class));
        }
        if (value.isSetSifRegistration()) {
            partyDocuments.setSifRegistration(ctx.convert(value.getSifRegistration(), IFNCRegistration.class));
        }
        return partyDocuments;
    }

}
