package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.ShareHolderUl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ShareHolderUL implements
        SwagConverter<ShareHolderUl, dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.ShareHolderUL> {

    @Override
    public ShareHolderUl toSwag(dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.ShareHolderUL value,
                                SwagConverterContext ctx) {
        return new ShareHolderUl()
                .address(value.getAddress())
                .capitalSharesPercent(BigDecimal.valueOf(value.getCapitalSharesPercent()))
                .date(value.getDate())
                .fullName(value.getFullName())
                .inn(value.getInn())
                .ogrn(value.getOgrn())
                .votingSharesPercent(BigDecimal.valueOf(value.getVotingSharesPercent()));
    }
}
