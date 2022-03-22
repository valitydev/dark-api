package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.IdentityDocument;
import dev.vality.swag.questionary.model.IdentityDocument.IdentityDocumentTypeEnum;
import dev.vality.swag.questionary.model.RussianDomesticPassport;
import org.springframework.stereotype.Component;

@Component
public class IdentityDocumentConverter implements
        ThriftConverter<IdentityDocument, dev.vality.swag.questionary.model.IdentityDocument>,
        SwagConverter<dev.vality.swag.questionary.model.IdentityDocument, IdentityDocument> {

    @Override
    public dev.vality.swag.questionary.model.IdentityDocument toSwag(IdentityDocument value,
                                                                       SwagConverterContext ctx) {
        if (value.isSetRussianDomesticPassword()) {
            return ctx.convert(value.getRussianDomesticPassword(), RussianDomesticPassport.class)
                    .identityDocumentType(IdentityDocumentTypeEnum.RUSSIANDOMESTICPASSPORT);
        } else {
            throw new IllegalArgumentException("Unknown identityDocument type: " + value.getClass().getName());
        }
    }

    @Override
    public IdentityDocument toThrift(dev.vality.swag.questionary.model.IdentityDocument value,
                                     ThriftConverterContext ctx) {
        IdentityDocument identityDocument = new IdentityDocument();
        if (value.getIdentityDocumentType() == IdentityDocumentTypeEnum.RUSSIANDOMESTICPASSPORT) {
            identityDocument.setRussianDomesticPassword(
                    ctx.convert(value, dev.vality.questionary.RussianDomesticPassport.class));
        } else {
            throw new IllegalArgumentException("Unknown identityDocument type: " + value.getIdentityDocumentType());
        }
        return identityDocument;
    }

}
