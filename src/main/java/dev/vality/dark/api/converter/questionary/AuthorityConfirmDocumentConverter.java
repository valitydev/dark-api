package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.AuthorityConfirmingDocument;
import org.springframework.stereotype.Component;

@Component
public class AuthorityConfirmDocumentConverter implements
        ThriftConverter<AuthorityConfirmingDocument, dev.vality.swag.questionary.model.AuthorityConfirmingDocument>,
        SwagConverter<dev.vality.swag.questionary.model.AuthorityConfirmingDocument, AuthorityConfirmingDocument> {

    @Override
    public dev.vality.swag.questionary.model.AuthorityConfirmingDocument toSwag(AuthorityConfirmingDocument value,
                                                                                  SwagConverterContext ctx) {
        var authorityConfirmingDocument = new dev.vality.swag.questionary.model.AuthorityConfirmingDocument();
        authorityConfirmingDocument.setDate(value.getDate());
        authorityConfirmingDocument.setNumber(value.getNumber());
        authorityConfirmingDocument.setType(value.getType());

        return authorityConfirmingDocument;
    }

    @Override
    public AuthorityConfirmingDocument toThrift(dev.vality.swag.questionary.model.AuthorityConfirmingDocument value,
                                                ThriftConverterContext ctx) {
        AuthorityConfirmingDocument authorityConfirmingDocument = new AuthorityConfirmingDocument();
        authorityConfirmingDocument.setDate(value.getDate());
        authorityConfirmingDocument.setType(value.getType());
        authorityConfirmingDocument.setNumber(value.getNumber());

        return authorityConfirmingDocument;
    }

}
