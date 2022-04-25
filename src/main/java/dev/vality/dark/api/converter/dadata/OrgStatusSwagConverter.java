package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.OrgStatus;
import org.springframework.stereotype.Component;

@Component
public class OrgStatusSwagConverter
        implements SwagConverter<OrgStatus, dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus> {

    @Override
    public OrgStatus toSwag(dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus value, SwagConverterContext ctx) {
        if (value == dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.ACTIVE) {
            return OrgStatus.ACTIVE;
        } else if (value == dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.LIQUIDATED) {
            return OrgStatus.LIQUIDATED;
        } else if (value == dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.LIQUIDATING) {
            return OrgStatus.LIQUIDATING;
        } else if (value == dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.REORGANIZING) {
            return OrgStatus.REORGANIZING;
        }
        throw new IllegalArgumentException("Unknown orgStatus: " + value.name());
    }

}
