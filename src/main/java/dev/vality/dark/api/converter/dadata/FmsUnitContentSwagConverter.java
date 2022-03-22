package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.FmsUnitContent;
import org.springframework.stereotype.Component;

@Component
public class FmsUnitContentSwagConverter
        implements SwagConverter<FmsUnitContent, dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitContent> {

    @Override
    public FmsUnitContent toSwag(dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitContent value,
                                 SwagConverterContext ctx) {
        return new FmsUnitContent()
                .code(value.getCode())
                .name(value.getName())
                .regionCode(value.getRegionCode())
                .type(value.getType())
                .value(value.getValue())
                .unrestrictedValue(value.getUnrestrictdValue());
    }

}
