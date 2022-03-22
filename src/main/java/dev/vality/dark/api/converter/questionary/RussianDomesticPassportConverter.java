package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.questionary.model.RussianDomesticPassport;
import org.springframework.stereotype.Component;

@Component
public class RussianDomesticPassportConverter implements
        ThriftConverter<dev.vality.questionary.RussianDomesticPassport, RussianDomesticPassport>,
        SwagConverter<RussianDomesticPassport, dev.vality.questionary.RussianDomesticPassport> {

    @Override
    public RussianDomesticPassport toSwag(dev.vality.questionary.RussianDomesticPassport value,
                                          SwagConverterContext ctx) {
        return new RussianDomesticPassport()
                .issuedAt(value.getIssuedAt())
                .issuer(value.getIssuer())
                .issuerCode(value.getIssuerCode())
                .seriesNumber(value.getSeriesNumber());
    }

    @Override
    public dev.vality.questionary.RussianDomesticPassport toThrift(RussianDomesticPassport value,
                                                                     ThriftConverterContext ctx) {
        return new dev.vality.questionary.RussianDomesticPassport()
                .setIssuerCode(value.getIssuerCode())
                .setIssuer(value.getIssuer())
                .setIssuedAt(value.getIssuedAt())
                .setSeriesNumber(value.getSeriesNumber());
    }

}
