package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.questionary.model.LicenseInfo;
import org.springframework.stereotype.Component;

@Component
public class LicenseInfoConverter implements
        ThriftConverter<dev.vality.questionary.LicenseInfo, LicenseInfo>,
        SwagConverter<LicenseInfo, dev.vality.questionary.LicenseInfo> {

    @Override
    public LicenseInfo toSwag(dev.vality.questionary.LicenseInfo value, SwagConverterContext ctx) {
        return new LicenseInfo()
                .effectiveDate(value.getEffectiveDate())
                .expirationDate(value.getExpirationDate())
                .issueDate(value.getIssueDate())
                .issuerName(value.getIssuerName())
                .licensedActivity(value.getLicensedActivity())
                .officialNum(value.getOfficialNum());
    }

    @Override
    public dev.vality.questionary.LicenseInfo toThrift(LicenseInfo value, ThriftConverterContext ctx) {
        return new dev.vality.questionary.LicenseInfo()
                .setExpirationDate(value.getExpirationDate())
                .setEffectiveDate(value.getEffectiveDate())
                .setIssueDate(value.getIssueDate())
                .setIssuerName(value.getIssuerName())
                .setOfficialNum(value.getOfficialNum())
                .setLicensedActivity(value.getLicensedActivity());
    }
}
