package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.ShareHolderOther;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ShareHolderOtherSwagConverter implements
        SwagConverter<ShareHolderOther, dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.ShareHolderOther> {

    @Override
    public ShareHolderOther toSwag(dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.ShareHolderOther value,
                                   SwagConverterContext ctx) {
        return new ShareHolderOther()
                .address(value.getAddress())
                .capitalSharesPercent(BigDecimal.valueOf(value.getCapitalSharesPercent()))
                .date(value.getDate())
                .fullName(value.getFullName())
                .votingSharesPercent(BigDecimal.valueOf(value.getVotingSharesPercent()));
    }
}
