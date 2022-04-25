package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.*;
import org.springframework.stereotype.Component;

@Component
public class BankContentSwagConverter
        implements SwagConverter<BankContent, dev.vality.questionary_proxy_aggr.dadata_bank.BankContent> {

    @Override
    public BankContent toSwag(dev.vality.questionary_proxy_aggr.dadata_bank.BankContent value,
                              SwagConverterContext ctx) {
        BankContent swagBankContent = new BankContent()
                .bic(value.getBic())
                .correspondentAccount(value.getCorrespondentAccount())
                .okpo(value.getOkpo())
                .phone(value.getPhone())
                .swift(value.getSwift())
                .value(value.getValue())
                .unrestrictedValue(value.getUnrestrictedValue())
                .rkc(value.getRkc())
                .registrationNumber(value.getRegistrationNumber());

        if (value.isSetAddress()) {
            swagBankContent.setAddress(ctx.convert(value.getAddress(), DaDataAddress.class));
        }
        if (value.isSetOpf()) {
            swagBankContent.setOpf(ctx.convert(value.getOpf(), Opf.class));
        }
        if (value.isSetPayment()) {
            swagBankContent.setPayment(convertPayment(value.getPayment()));
        }
        if (value.isSetStatus()) {
            swagBankContent.setStatus(ctx.convert(value.getStatus(), DaDataState.class));
        }

        return swagBankContent;
    }

    private Payment convertPayment(dev.vality.questionary_proxy_aggr.base_dadata.Payment payment) {
        Payment swagPayment = new Payment();
        swagPayment.setName(payment.getName());
        swagPayment.setFullName(payment.getFullName());
        swagPayment.setShortName(payment.getShortName());
        return swagPayment;
    }

}
