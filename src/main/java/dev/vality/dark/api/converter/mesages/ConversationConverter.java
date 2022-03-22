package dev.vality.dark.api.converter.mesages;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.messages.model.Conversation;
import dev.vality.swag.messages.model.ConversationStatus;
import dev.vality.swag.messages.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConversationConverter implements SwagConverter<Conversation, dev.vality.damsel.messages.Conversation>,
        ThriftConverter<dev.vality.damsel.messages.Conversation, Conversation> {

    @Override
    public Conversation toSwag(dev.vality.damsel.messages.Conversation value, SwagConverterContext ctx) {
        Conversation conversation = new Conversation();
        conversation.setConversationId(value.getConversationId());
        List<Message> messageList = value.getMessages().stream()
                .map(message -> ctx.convert(message, Message.class))
                .collect(Collectors.toList());
        conversation.setMessages(messageList);
        conversation.setStatus(ctx.convert(value.getStatus(), ConversationStatus.class));

        return conversation;
    }

    @Override
    public dev.vality.damsel.messages.Conversation toThrift(Conversation value, ThriftConverterContext ctx) {
        dev.vality.damsel.messages.Conversation conversation = new dev.vality.damsel.messages.Conversation();
        conversation.setConversationId(value.getConversationId());
        List<dev.vality.damsel.messages.Message> messageList = value.getMessages().stream()
                .map(message -> ctx.convert(message, dev.vality.damsel.messages.Message.class))
                .collect(Collectors.toList());
        conversation.setMessages(messageList);
        conversation.setStatus(ctx.convert(value.getStatus(), dev.vality.damsel.messages.ConversationStatus.class));

        return conversation;
    }
}
