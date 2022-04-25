package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.questionary_proxy_aggr.base_dadata.License;
import dev.vality.swag.questionary_aggr_proxy.model.DaDataLicense;
import org.springframework.stereotype.Component;

@Component
public class DaDataLicensesSwagConverter implements SwagConverter<DaDataLicense, License> {

    @Override
    public DaDataLicense toSwag(License value, SwagConverterContext ctx) {
        return new DaDataLicense()
                .activities(value.getActivities())
                .addresses(value.getAddresses())
                .issueAuthority(value.getIssueAuthority())
                .issueDate(value.getIssueDate())
                .number(value.getNumber())
                .series(value.getSeries())
                .suspendAuthority(value.getSuspendAuthority())
                .suspendDate(value.getSuspendDate())
                .validFrom(value.getValidFrom())
                .validTo(value.getValidTo());
    }

}
