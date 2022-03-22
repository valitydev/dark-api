package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.ParsedAddressRF;
import dev.vality.swag.questionary_aggr_proxy.model.Toponim;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("AbbreviationAsWordInName")
public class ParsedAddressRFSwagConverter implements
        SwagConverter<ParsedAddressRF, dev.vality.questionary_proxy_aggr.base_kontur_focus.ParsedAddressRF> {

    @Override
    public ParsedAddressRF toSwag(dev.vality.questionary_proxy_aggr.base_kontur_focus.ParsedAddressRF value,
                                  SwagConverterContext ctx) {
        ParsedAddressRF swagParsedAddressRF = new ParsedAddressRF();
        if (value.isSetBulk()) {
            swagParsedAddressRF.setBulk(ctx.convert(value.getBulk(), Toponim.class));
        }
        if (value.isSetBulkRaw()) {
            swagParsedAddressRF.setBulkRaw(value.getBulkRaw());
        }
        if (value.isSetCity()) {
            swagParsedAddressRF.setCity(ctx.convert(value.getCity(), Toponim.class));
        }
        if (value.isSetDistrict()) {
            swagParsedAddressRF.setDistrict(ctx.convert(value.getDistrict(), Toponim.class));
        }
        if (value.isSetHouse()) {
            swagParsedAddressRF.setHouse(ctx.convert(value.getHouse(), Toponim.class));
        }
        if (value.isSetHouseRaw()) {
            swagParsedAddressRF.setHouseRaw(value.getHouseRaw());
        }
        if (value.isSetFlat()) {
            swagParsedAddressRF.setFlat(ctx.convert(value.getFlat(), Toponim.class));
        }
        if (value.isSetRegionName()) {
            swagParsedAddressRF.setRegionName(ctx.convert(value.getRegionName(), Toponim.class));
        }
        if (value.isSetSettlement()) {
            swagParsedAddressRF.setSettlement(ctx.convert(value.getSettlement(), Toponim.class));
        }
        if (value.isSetStreet()) {
            swagParsedAddressRF.setStreet(ctx.convert(value.getStreet(), Toponim.class));
        }
        swagParsedAddressRF.setFlatRaw(value.getFlatRaw());
        swagParsedAddressRF.setKladrCode(value.getKladrCode());
        swagParsedAddressRF.setRegionCode(value.getRegionCode());
        swagParsedAddressRF.setZipCode(value.getZipCode());

        return swagParsedAddressRF;
    }

}
