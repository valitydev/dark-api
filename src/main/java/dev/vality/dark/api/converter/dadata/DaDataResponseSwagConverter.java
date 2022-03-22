package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.questionary_proxy_aggr.dadata_address.AddressResponse;
import dev.vality.questionary_proxy_aggr.dadata_bank.BankResponse;
import dev.vality.questionary_proxy_aggr.dadata_fio.FioResponse;
import dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitResponse;
import dev.vality.questionary_proxy_aggr.dadata_okved2.OkvedResponse;
import dev.vality.questionary_proxy_aggr.dadata_party.PartyResponse;
import dev.vality.swag.questionary_aggr_proxy.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DaDataResponseSwagConverter
        implements SwagConverter<DaDataResponse, dev.vality.questionary_proxy_aggr.dadata_api.DaDataResponse> {

    @Override
    public DaDataResponse toSwag(dev.vality.questionary_proxy_aggr.dadata_api.DaDataResponse value,
                                 SwagConverterContext ctx) {
        if (value.isSetAddressResponse()) {
            var swagAddressResponse = new dev.vality.swag.questionary_aggr_proxy.model.AddressResponse();
            AddressResponse addressResponse = value.getAddressResponse();
            List<DaDataAddress> daDataAddressList = addressResponse.getSuggestions().stream()
                    .map(address -> ctx.convert(address, DaDataAddress.class))
                    .collect(Collectors.toList());
            swagAddressResponse.setSuggestions(daDataAddressList);
            swagAddressResponse.setDaDataResponseType(swagAddressResponse.getClass().getSimpleName());

            return swagAddressResponse;
        } else if (value.isSetBankResponse()) {
            var swagBankResponse = new dev.vality.swag.questionary_aggr_proxy.model.BankResponse();
            BankResponse bankResponse = value.getBankResponse();
            List<BankContent> bankContentList = bankResponse.getSuggestions().stream()
                    .map(bankContent -> ctx.convert(bankContent, BankContent.class))
                    .collect(Collectors.toList());
            swagBankResponse.setSuggestions(bankContentList);
            swagBankResponse.setDaDataResponseType(swagBankResponse.getClass().getSimpleName());

            return swagBankResponse;
        } else if (value.isSetFioResponse()) {
            var swagFioResponse = new dev.vality.swag.questionary_aggr_proxy.model.FioResponse();
            FioResponse fioResponse = value.getFioResponse();
            List<FioContent> fioContentList = fioResponse.getSuggestions().stream()
                    .map(fioContent -> ctx.convert(fioContent, FioContent.class))
                    .collect(Collectors.toList());
            swagFioResponse.setSuggestions(fioContentList);
            swagFioResponse.setDaDataResponseType(swagFioResponse.getClass().getSimpleName());

            return swagFioResponse;
        } else if (value.isSetOkvedResponse()) {
            var swagOkvedResponse = new dev.vality.swag.questionary_aggr_proxy.model.OkvedResponse();
            OkvedResponse okvedResponse = value.getOkvedResponse();
            List<OkvedContent> okvedContentList = okvedResponse.getSuggestions().stream()
                    .map(okvedContent -> ctx.convert(okvedContent, OkvedContent.class))
                    .collect(Collectors.toList());
            swagOkvedResponse.setSuggestions(okvedContentList);
            swagOkvedResponse.setDaDataResponseType(swagOkvedResponse.getClass().getSimpleName());

            return swagOkvedResponse;
        } else if (value.isSetFmsUnitResponse()) {
            var swagFmsUnitResponse = new dev.vality.swag.questionary_aggr_proxy.model.FmsUnitResponse();
            FmsUnitResponse fmsUnitResponse = value.getFmsUnitResponse();
            List<FmsUnitContent> fmsUnitContentList = fmsUnitResponse.getSuggestions().stream()
                    .map(fmsUnitContent -> ctx.convert(fmsUnitContent, FmsUnitContent.class))
                    .collect(Collectors.toList());
            swagFmsUnitResponse.setSuggestions(fmsUnitContentList);
            swagFmsUnitResponse.setDaDataResponseType(swagFmsUnitResponse.getClass().getSimpleName());

            return swagFmsUnitResponse;
        } else if (value.isSetPartyResponse()) {
            var swagPartyResponse = new dev.vality.swag.questionary_aggr_proxy.model.PartyResponse();
            PartyResponse partyResponse = value.getPartyResponse();
            List<PartyContent> partyContentList = partyResponse.getSuggestions().stream()
                    .map(partyContent -> ctx.convert(partyContent, PartyContent.class))
                    .collect(Collectors.toList());
            swagPartyResponse.setSuggestions(partyContentList);
            swagPartyResponse.setDaDataResponseType(swagPartyResponse.getClass().getSimpleName());

            return swagPartyResponse;
        }

        throw new IllegalArgumentException("Unknown response type: " + value.getClass().getName());
    }

}
