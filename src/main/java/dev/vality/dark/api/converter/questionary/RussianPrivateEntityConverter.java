package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.RussianPrivateEntity;
import dev.vality.swag.questionary.model.ContactInfo;
import org.springframework.stereotype.Component;

@Component
public class RussianPrivateEntityConverter implements
        ThriftConverter<RussianPrivateEntity, dev.vality.swag.questionary.model.RussianPrivateEntity>,
        SwagConverter<dev.vality.swag.questionary.model.RussianPrivateEntity, RussianPrivateEntity> {

    @Override
    public dev.vality.swag.questionary.model.RussianPrivateEntity toSwag(RussianPrivateEntity value,
                                                                           SwagConverterContext ctx) {
        var russianPrivateEntity = new dev.vality.swag.questionary.model.RussianPrivateEntity()
                .actualAddress(value.getActualAddress())
                .birthDate(value.getBirthDate())
                .birthPlace(value.getBirthPlace())
                .citizenship(value.getCitizenship())
                .residenceAddress(value.getResidenceAddress());
        if (value.isSetContactInfo()) {
            russianPrivateEntity.setContactInfo(ctx.convert(value.getContactInfo(), ContactInfo.class));
        }
        russianPrivateEntity.setFio(value.getFio());

        return russianPrivateEntity;
    }

    @Override
    public RussianPrivateEntity toThrift(dev.vality.swag.questionary.model.RussianPrivateEntity value,
                                         ThriftConverterContext ctx) {
        RussianPrivateEntity russianPrivateEntity = new RussianPrivateEntity()
                .setCitizenship(value.getCitizenship())
                .setBirthDate(value.getBirthDate())
                .setBirthPlace(value.getBirthPlace())
                .setActualAddress(value.getActualAddress())
                .setResidenceAddress(value.getResidenceAddress());
        if (value.getContactInfo() != null) {
            russianPrivateEntity
                    .setContactInfo(ctx.convert(value.getContactInfo(), dev.vality.questionary.ContactInfo.class));
        }
        russianPrivateEntity.setFio(value.getFio());

        return russianPrivateEntity;
    }

}
