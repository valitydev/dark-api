package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Share;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ShareSwagConverter
        implements SwagConverter<Share, dev.vality.questionary_proxy_aggr.base_kontur_focus.Share> {

    @Override
    public Share toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.Share value, SwagConverterContext ctx) {
        return new Share()
                .percentageDenominator(value.getPercentageDenominator())
                .percentageNominator(value.getPercentageNominator())
                .percentagePlain(BigDecimal.valueOf(value.getPercentagePlain()))
                .sum(value.getSum());
    }
}
