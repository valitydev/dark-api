package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.RussianBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RussianBankAccountConverter implements
        ThriftConverter<RussianBankAccount, dev.vality.swag.questionary.model.RussianBankAccount>,
        SwagConverter<dev.vality.swag.questionary.model.RussianBankAccount, RussianBankAccount> {

    @Override
    public dev.vality.swag.questionary.model.RussianBankAccount toSwag(RussianBankAccount value,
                                                                         SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.RussianBankAccount()
                .account(value.getAccount())
                .bankBik(value.getBankBik())
                .bankName(value.getBankName())
                .bankPostAccount(value.getBankPostAccount());
    }

    @Override
    public RussianBankAccount toThrift(dev.vality.swag.questionary.model.RussianBankAccount value,
                                       ThriftConverterContext ctx) {
        return new RussianBankAccount()
                .setBankName(value.getBankName())
                .setBankBik(value.getBankBik())
                .setBankPostAccount(value.getBankPostAccount())
                .setAccount(value.getAccount());
    }

}
