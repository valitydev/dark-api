package dev.vality.dark.api.converter.mesages;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.messages.model.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageConverter implements SwagConverter<Message, dev.vality.damsel.messages.Message>,
        ThriftConverter<dev.vality.damsel.messages.Message, Message> {

    @Override
    public Message toSwag(dev.vality.damsel.messages.Message value, SwagConverterContext ctx) {
        return new Message()
                .messageId(value.getMessageId())
                .text(value.getText())
                .timestamp(value.getTimestamp())
                .userId(value.getUserId());
    }

    @Override
    public dev.vality.damsel.messages.Message toThrift(Message value, ThriftConverterContext ctx) {
        return new dev.vality.damsel.messages.Message()
                .setMessageId(value.getMessageId())
                .setText(value.getText())
                .setTimestamp(value.getTimestamp())
                .setUserId(value.getUserId());
    }

}
