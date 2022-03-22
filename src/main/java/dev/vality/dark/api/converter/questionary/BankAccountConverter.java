package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.BankAccount;
import dev.vality.questionary.InternationalBankAccount;
import dev.vality.questionary.RussianBankAccount;
import dev.vality.swag.questionary.model.BankAccount.BankAccountTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class BankAccountConverter implements
        ThriftConverter<BankAccount, dev.vality.swag.questionary.model.BankAccount>,
        SwagConverter<dev.vality.swag.questionary.model.BankAccount, BankAccount> {

    @Override
    public BankAccount toThrift(dev.vality.swag.questionary.model.BankAccount value, ThriftConverterContext ctx) {
        if (value.getBankAccountType() == BankAccountTypeEnum.RUSSIANBANKACCOUNT) {
            return BankAccount.russian_bank_account(ctx.convert(value, RussianBankAccount.class));
        } else if (value.getBankAccountType() == BankAccountTypeEnum.INTERNATIONALBANKACCOUNT) {
            return BankAccount.international_bank_account(ctx.convert(value, InternationalBankAccount.class));
        }
        throw new IllegalArgumentException("Unknown bank account type: " + value.getClass().getName());
    }

    @Override
    public dev.vality.swag.questionary.model.BankAccount toSwag(BankAccount value, SwagConverterContext ctx) {
        if (value.isSetRussianBankAccount()) {
            var russianBankAccount = ctx.convert(
                    value.getRussianBankAccount(),
                    dev.vality.swag.questionary.model.RussianBankAccount.class
            );
            russianBankAccount.setBankAccountType(BankAccountTypeEnum.RUSSIANBANKACCOUNT);
            return russianBankAccount;
        } else if (value.isSetInternationalBankAccount()) {
            var internationalBankAccount = ctx.convert(
                    value.getInternationalBankAccount(),
                    dev.vality.swag.questionary.model.InternationalBankAccount.class
            );
            internationalBankAccount.setBankAccountType(BankAccountTypeEnum.INTERNATIONALBANKACCOUNT);
            return internationalBankAccount;
        }
        throw new IllegalArgumentException("Unknown bank account type: " + value.getClass().getName());
    }
}
