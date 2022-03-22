package dev.vality.dark.api.converter.mesages;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.messages.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements SwagConverter<User, dev.vality.damsel.messages.User>,
        ThriftConverter<dev.vality.damsel.messages.User, User> {

    @Override
    public User toSwag(dev.vality.damsel.messages.User value, SwagConverterContext ctx) {
        return new User()
                .userId(value.getUserId())
                .fullName(value.getFullname())
                .email(value.getEmail());
    }

    @Override
    public dev.vality.damsel.messages.User toThrift(User value, ThriftConverterContext ctx) {
        return new dev.vality.damsel.messages.User()
                .setUserId(value.getUserId())
                .setFullname(value.getFullName())
                .setEmail(value.getEmail());
    }

}
