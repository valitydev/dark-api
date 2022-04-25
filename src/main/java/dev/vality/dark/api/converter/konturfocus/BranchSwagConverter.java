package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Branch;
import dev.vality.swag.questionary_aggr_proxy.model.ForeignAddress;
import dev.vality.swag.questionary_aggr_proxy.model.ParsedAddressRF;
import org.springframework.stereotype.Component;

@Component
public class BranchSwagConverter
        implements SwagConverter<Branch, dev.vality.questionary_proxy_aggr.base_kontur_focus.Branch> {

    @Override
    public Branch toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.Branch value, SwagConverterContext ctx) {
        Branch branch = new Branch();
        branch.setName(value.getName());
        branch.setDate(value.getDate());
        if (value.isSetAddressRf()) {
            branch.setAddressRf(ctx.convert(value.getAddressRf(), ParsedAddressRF.class));
        }
        if (value.isSetForeignAddress()) {
            branch.setForeignAddress(ctx.convert(value.getForeignAddress(), ForeignAddress.class));
        }
        return branch;
    }

}
