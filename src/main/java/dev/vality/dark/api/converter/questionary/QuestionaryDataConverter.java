package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.manage.QuestionaryData;
import dev.vality.swag.questionary.model.BankAccount;
import dev.vality.swag.questionary.model.ContactInfo;
import dev.vality.swag.questionary.model.Contractor;
import dev.vality.swag.questionary.model.ShopInfo;
import org.springframework.stereotype.Component;

@Component
public class QuestionaryDataConverter implements
        ThriftConverter<QuestionaryData, dev.vality.swag.questionary.model.QuestionaryData>,
        SwagConverter<dev.vality.swag.questionary.model.QuestionaryData, QuestionaryData> {

    @Override
    public dev.vality.swag.questionary.model.QuestionaryData toSwag(QuestionaryData value, SwagConverterContext ctx) {
        var questionaryData = new dev.vality.swag.questionary.model.QuestionaryData();
        if (value.isSetBankAccount()) {
            questionaryData.setBankAccount(ctx.convert(value.getBankAccount(), BankAccount.class));
        }
        if (value.isSetContactInfo()) {
            questionaryData.setContactInfo(ctx.convert(value.getContactInfo(), ContactInfo.class));
        }
        if (value.isSetShopInfo()) {
            questionaryData.setShopInfo(ctx.convert(value.getShopInfo(), ShopInfo.class));
        }
        if (value.isSetContractor()) {
            questionaryData.setContractor(ctx.convert(value.getContractor(), Contractor.class));
        }

        return questionaryData;
    }

    @Override
    public QuestionaryData toThrift(dev.vality.swag.questionary.model.QuestionaryData value,
                                    ThriftConverterContext ctx) {
        QuestionaryData questionaryData = new QuestionaryData();
        if (value.getBankAccount() != null) {
            questionaryData
                    .setBankAccount(ctx.convert(value.getBankAccount(), dev.vality.questionary.BankAccount.class));
        }
        if (value.getContactInfo() != null) {
            questionaryData
                    .setContactInfo(ctx.convert(value.getContactInfo(), dev.vality.questionary.ContactInfo.class));
        }
        if (value.getShopInfo() != null) {
            questionaryData.setShopInfo(ctx.convert(value.getShopInfo(), dev.vality.questionary.ShopInfo.class));
        }
        if (value.getContractor() != null) {
            questionaryData
                    .setContractor(ctx.convert(value.getContractor(), dev.vality.questionary.Contractor.class));
        }
        return questionaryData;
    }

}
