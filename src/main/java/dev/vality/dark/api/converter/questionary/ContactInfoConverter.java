package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.ContactInfo;
import org.springframework.stereotype.Component;

@Component
public class ContactInfoConverter implements
        ThriftConverter<ContactInfo, dev.vality.swag.questionary.model.ContactInfo>,
        SwagConverter<dev.vality.swag.questionary.model.ContactInfo, ContactInfo> {

    @Override
    public dev.vality.swag.questionary.model.ContactInfo toSwag(ContactInfo value, SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.ContactInfo()
                .email(value.getEmail())
                .phoneNumber(value.getPhoneNumber());
    }

    @Override
    public ContactInfo toThrift(dev.vality.swag.questionary.model.ContactInfo value, ThriftConverterContext ctx) {
        return new ContactInfo()
                .setPhoneNumber(value.getPhoneNumber())
                .setEmail(value.getEmail());
    }
}
