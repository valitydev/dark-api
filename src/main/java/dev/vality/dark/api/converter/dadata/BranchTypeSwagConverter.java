package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.BranchType;
import org.springframework.stereotype.Component;

@Component
public class BranchTypeSwagConverter
        implements SwagConverter<BranchType, dev.vality.questionary_proxy_aggr.base_dadata.BranchType> {

    @Override
    public BranchType toSwag(dev.vality.questionary_proxy_aggr.base_dadata.BranchType value,
                             SwagConverterContext ctx) {
        if (value == dev.vality.questionary_proxy_aggr.base_dadata.BranchType.BRANCH) {
            return BranchType.BRANCH;
        } else if (value == dev.vality.questionary_proxy_aggr.base_dadata.BranchType.MAIN) {
            return BranchType.MAIN;
        }
        throw new IllegalArgumentException("Unknown branchType: " + value.name());
    }

}
