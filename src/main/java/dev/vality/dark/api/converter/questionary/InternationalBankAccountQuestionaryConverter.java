package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.file.storage.base.Residence;
import dev.vality.questionary.InternationalBankAccount;
import dev.vality.questionary.InternationalBankDetails;
import dev.vality.swag.questionary.model.CorrespondentAccount;
import org.springframework.stereotype.Component;

@Component
public class InternationalBankAccountQuestionaryConverter implements
        ThriftConverter<InternationalBankAccount, dev.vality.swag.questionary.model.InternationalBankAccount>,
        SwagConverter<dev.vality.swag.questionary.model.InternationalBankAccount, InternationalBankAccount> {

    @Override
    public dev.vality.swag.questionary.model.InternationalBankAccount toSwag(
            InternationalBankAccount value,
            SwagConverterContext ctx
    ) {
        var internationalBankAccount = new dev.vality.swag.questionary.model.InternationalBankAccount()
                .number(value.getNumber())
                .iban(value.getIban())
                .accountHolder(value.getAccountHolder())
                .bank(getBankDetails(value.getBank()));

        if (value.isSetCorrespondentAccount()) {
            InternationalBankAccount swagCorrAccount = value.getCorrespondentAccount();
            internationalBankAccount.setCorrespondentAccount(new CorrespondentAccount()
                    .number(swagCorrAccount.getNumber())
                    .iban(swagCorrAccount.getIban())
                    .accountHolder(swagCorrAccount.getAccountHolder())
                    .bank(getCorrBankDetails(swagCorrAccount.getBank()))
            );
        }
        return internationalBankAccount;
    }

    @Override
    public InternationalBankAccount toThrift(
            dev.vality.swag.questionary.model.InternationalBankAccount value,
            ThriftConverterContext ctx
    ) {
        InternationalBankAccount internationalBankAccount = new InternationalBankAccount()
                .setNumber(value.getNumber())
                .setIban(value.getIban())
                .setAccountHolder(value.getAccountHolder())
                .setBank(getBankDetails(value.getBank()));

        if (value.getCorrespondentAccount() != null) {
            var thriftCorrespondentAccount = value.getCorrespondentAccount();
            InternationalBankAccount corrBankAccount = new InternationalBankAccount()
                    .setNumber(thriftCorrespondentAccount.getAccountHolder())
                    .setIban(thriftCorrespondentAccount.getIban())
                    .setAccountHolder(thriftCorrespondentAccount.getAccountHolder())
                    .setBank(getBankDetails(thriftCorrespondentAccount.getBank()));
            internationalBankAccount.setCorrespondentAccount(corrBankAccount);
        }

        return internationalBankAccount;
    }

    private dev.vality.swag.questionary.model.CorrespondentBankDetails getCorrBankDetails(
            InternationalBankDetails swagBank
    ) {
        if (swagBank != null) {
            return new dev.vality.swag.questionary.model.CorrespondentBankDetails()
                    .abaRtn(swagBank.getAbaRtn())
                    .address(swagBank.getAddress())
                    .name(swagBank.getName())
                    .bic(swagBank.getBic())
                    .country(swagBank.getCountry() == null
                            ? null
                            : swagBank.getCountry().getValue());
        } else {
            return null;
        }
    }

    private dev.vality.swag.questionary.model.InternationalBankDetails getBankDetails(
            InternationalBankDetails swagBank
    ) {
        if (swagBank != null) {
            return new dev.vality.swag.questionary.model.InternationalBankDetails()
                    .abaRtn(swagBank.getAbaRtn())
                    .address(swagBank.getAddress())
                    .name(swagBank.getName())
                    .bic(swagBank.getBic())
                    .country(swagBank.getCountry() == null
                            ? null
                            : swagBank.getCountry().getValue());
        } else {
            return null;
        }
    }

    private InternationalBankDetails getBankDetails(
            dev.vality.swag.questionary.model.CorrespondentBankDetails thriftBank
    ) {
        return thriftBank == null ? null : getInternationalBankDetails(
                thriftBank.getName(),
                thriftBank.getCountry(),
                thriftBank.getAbaRtn(),
                thriftBank.getAddress(),
                thriftBank.getBic());
    }

    private InternationalBankDetails getBankDetails(
            dev.vality.swag.questionary.model.InternationalBankDetails thriftBank
    ) {
        return thriftBank == null ? null : getInternationalBankDetails(
                thriftBank.getName(),
                thriftBank.getCountry(),
                thriftBank.getAbaRtn(),
                thriftBank.getAddress(),
                thriftBank.getBic());
    }

    private InternationalBankDetails getInternationalBankDetails(String name,
                                                                 Integer country,
                                                                 String abaRtn,
                                                                 String address,
                                                                 String bic) {
        InternationalBankDetails bankDetails = new InternationalBankDetails()
                .setName(name)
                .setCountry(country == null
                        ? null
                        : Residence.findByValue(country))
                .setAbaRtn(abaRtn)
                .setAddress(address)
                .setBic(bic);
        if (country != null) {
            bankDetails.setCountry(Residence.findByValue(country));
        }
        return bankDetails;
    }

}
