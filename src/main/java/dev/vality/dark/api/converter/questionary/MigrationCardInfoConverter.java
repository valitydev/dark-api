package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.MigrationCardInfo;
import org.springframework.stereotype.Component;

@Component
public class MigrationCardInfoConverter implements
        ThriftConverter<MigrationCardInfo, dev.vality.swag.questionary.model.MigrationCardInfo>,
        SwagConverter<dev.vality.swag.questionary.model.MigrationCardInfo, MigrationCardInfo> {

    @Override
    public dev.vality.swag.questionary.model.MigrationCardInfo toSwag(MigrationCardInfo value,
                                                                        SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.MigrationCardInfo()
                .beginningDate(value.getBeginningDate())
                .cardNumber(value.getCardNumber())
                .expirationDate(value.getExpirationDate());
    }

    @Override
    public MigrationCardInfo toThrift(dev.vality.swag.questionary.model.MigrationCardInfo value,
                                      ThriftConverterContext ctx) {
        return new MigrationCardInfo()
                .setExpirationDate(value.getExpirationDate())
                .setBeginningDate(value.getBeginningDate())
                .setCardNumber(value.getCardNumber());
    }

}
