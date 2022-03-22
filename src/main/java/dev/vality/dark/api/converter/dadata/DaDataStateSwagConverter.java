package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.DaDataState;
import dev.vality.swag.questionary_aggr_proxy.model.OrgStatus;
import org.springframework.stereotype.Component;

@Component
public class DaDataStateSwagConverter
        implements SwagConverter<DaDataState, dev.vality.questionary_proxy_aggr.base_dadata.DaDataState> {

    @Override
    public DaDataState toSwag(dev.vality.questionary_proxy_aggr.base_dadata.DaDataState value,
                              SwagConverterContext ctx) {
        DaDataState swagDaDataState = new DaDataState()
                .actualityDate(value.getActualityDate())
                .liquidationDate(value.getLiquidationDate())
                .registratonDate(value.getRegistrationDate());
        if (value.isSetStatus()) {
            swagDaDataState.setStatus(ctx.convert(value.getStatus(), OrgStatus.class));
        }
        return swagDaDataState;
    }

}
