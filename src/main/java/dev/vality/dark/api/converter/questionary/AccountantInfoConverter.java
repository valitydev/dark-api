package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.*;
import dev.vality.swag.questionary.model.AccountantInfo.AccountantInfoTypeEnum;
import dev.vality.swag.questionary.model.WithChiefAccountant;
import dev.vality.swag.questionary.model.WithoutChiefAccountingOrganization;
import org.springframework.stereotype.Component;

@Component
public class AccountantInfoConverter implements
        ThriftConverter<AccountantInfo, dev.vality.swag.questionary.model.AccountantInfo>,
        SwagConverter<dev.vality.swag.questionary.model.AccountantInfo, AccountantInfo> {

    @Override
    public dev.vality.swag.questionary.model.AccountantInfo toSwag(AccountantInfo value, SwagConverterContext ctx) {
        if (value.isSetWithChiefAccountant()) {
            WithChiefAccountant withChiefAccountant = new WithChiefAccountant();
            withChiefAccountant.setAccountantInfoType(AccountantInfoTypeEnum.WITHCHIEFACCOUNTANT);

            return withChiefAccountant;
        } else if (value.isSetWithoutChiefAccountant()) {
            if (value.getWithoutChiefAccountant().isSetHeadAccounting()) {
                var headAccounting = new dev.vality.swag.questionary.model.WithoutChiefHeadAccounting();
                headAccounting.setAccountantInfoType(AccountantInfoTypeEnum.WITHOUTCHIEFHEADACCOUNTING);

                return headAccounting;
            } else if (value.getWithoutChiefAccountant().isSetIndividualAccountant()) {
                var individualAccountant = new dev.vality.swag.questionary.model.WithoutChiefIndividualAccountant();
                individualAccountant.setAccountantInfoType(AccountantInfoTypeEnum.WITHOUTCHIEFINDIVIDUALACCOUNTANT);

                return individualAccountant;
            } else if (value.getWithoutChiefAccountant().isSetAccountingOrganization()) {
                var accountingOrganization =
                        new dev.vality.swag.questionary.model.WithoutChiefAccountingOrganization();
                accountingOrganization.setInn(value.getWithoutChiefAccountant().getAccountingOrganization().getInn());
                accountingOrganization.setAccountantInfoType(AccountantInfoTypeEnum.WITHOUTCHIEFACCOUNTINGORGANIZATION);

                return accountingOrganization;
            } else {
                throw new IllegalArgumentException("Unknown withoutChiefAccountant type: " +
                        value.getWithoutChiefAccountant().getClass().getName());
            }
        } else {
            throw new IllegalArgumentException("Unknown withChiefAccountant type: " +
                    value.getWithChiefAccountant().getClass().getName());
        }
    }

    @Override
    public AccountantInfo toThrift(dev.vality.swag.questionary.model.AccountantInfo value,
                                   ThriftConverterContext ctx) {
        WithoutChiefAccountant withoutChiefAccountant = new WithoutChiefAccountant();
        switch (value.getAccountantInfoType()) {
            case WITHCHIEFACCOUNTANT:
                return AccountantInfo.with_chief_accountant(new dev.vality.questionary.WithChiefAccountant());
            case WITHOUTCHIEFHEADACCOUNTING:
                withoutChiefAccountant.setHeadAccounting(new HeadAccounting());

                return AccountantInfo.without_chief_accountant(withoutChiefAccountant);
            case WITHOUTCHIEFACCOUNTINGORGANIZATION:
                WithoutChiefAccountingOrganization swagWithoutChiefAccountantOrg =
                        (WithoutChiefAccountingOrganization) value;
                AccountingOrganization accountingOrganization = new AccountingOrganization();
                accountingOrganization.setInn(swagWithoutChiefAccountantOrg.getInn());
                withoutChiefAccountant.setAccountingOrganization(accountingOrganization);

                return AccountantInfo.without_chief_accountant(withoutChiefAccountant);
            case WITHOUTCHIEFINDIVIDUALACCOUNTANT:
                withoutChiefAccountant.setIndividualAccountant(new IndividualAccountant());

                return AccountantInfo.without_chief_accountant(withoutChiefAccountant);
            default:
                throw new IllegalArgumentException("Unknown accountantInfo type: " + value.getAccountantInfoType());
        }
    }

}
