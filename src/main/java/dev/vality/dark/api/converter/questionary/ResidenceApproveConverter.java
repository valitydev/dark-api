package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.ResidenceApprove;
import org.springframework.stereotype.Component;

@Component
public class ResidenceApproveConverter implements
        ThriftConverter<ResidenceApprove, dev.vality.swag.questionary.model.ResidenceApprove>,
        SwagConverter<dev.vality.swag.questionary.model.ResidenceApprove, ResidenceApprove> {

    @Override
    public dev.vality.swag.questionary.model.ResidenceApprove toSwag(ResidenceApprove value,
                                                                       SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.ResidenceApprove()
                .beginningDate(value.getBeginningDate())
                .expirationDate(value.getExpirationDate())
                .name(value.getName())
                .number(value.getNumber())
                .series(value.getSeries());
    }

    @Override
    public ResidenceApprove toThrift(dev.vality.swag.questionary.model.ResidenceApprove value,
                                     ThriftConverterContext ctx) {
        ResidenceApprove residenceApprove = new ResidenceApprove();
        residenceApprove.setExpirationDate(value.getExpirationDate());
        residenceApprove.setBeginningDate(value.getBeginningDate());
        residenceApprove.setSeries(value.getSeries());
        residenceApprove.setNumber(value.getNumber());
        residenceApprove.setName(value.getName());
        return residenceApprove;
    }

}
