package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.ReqKppHistory;
import org.springframework.stereotype.Component;

@Component
public class ReqKppHistorySwagConverter
        implements SwagConverter<ReqKppHistory, dev.vality.questionary_proxy_aggr.kontur_focus_req.ReqKppHistory> {

    @Override
    public ReqKppHistory toSwag(dev.vality.questionary_proxy_aggr.kontur_focus_req.ReqKppHistory value,
                                SwagConverterContext ctx) {
        ReqKppHistory swagReqKppHistory = new ReqKppHistory();
        swagReqKppHistory.setDate(value.getDate());
        swagReqKppHistory.setKpp(value.getKpp());
        return swagReqKppHistory;
    }

}
