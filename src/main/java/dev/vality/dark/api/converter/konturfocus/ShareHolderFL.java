package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.ShareHolderFl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ShareHolderFL implements
        SwagConverter<ShareHolderFl, dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.ShareHolderFl> {

    @Override
    public ShareHolderFl toSwag(dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.ShareHolderFl value,
                                SwagConverterContext ctx) {
        return new ShareHolderFl()
                .address(value.getAddress())
                .capitalSharesPercent(BigDecimal.valueOf(value.getCapitalSharesPercent()))
                .date(value.getDate())
                .fio(value.getFio())
                .votingSharesPercent(BigDecimal.valueOf(value.getVotingSharesPercent()));
    }
}
