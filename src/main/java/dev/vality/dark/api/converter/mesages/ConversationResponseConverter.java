package dev.vality.dark.api.converter.mesages;

import dev.vality.damsel.messages.GetConversationResponse;
import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.messages.model.Conversation;
import dev.vality.swag.messages.model.ConversationResponse;
import dev.vality.swag.messages.model.ConversationResponseUsers;
import dev.vality.swag.messages.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ConversationResponseConverter implements SwagConverter<ConversationResponse, GetConversationResponse>,
        ThriftConverter<GetConversationResponse, ConversationResponse> {

    @Override
    public ConversationResponse toSwag(GetConversationResponse value, SwagConverterContext ctx) {
        ConversationResponse conversationResponse = new ConversationResponse();
        List<Conversation> conversationList = value.getConversations().stream()
                .map(conversation -> ctx.convert(conversation, Conversation.class))
                .collect(Collectors.toList());
        conversationResponse.setConversations(conversationList);

        Map<String, ConversationResponseUsers> users = value.getUsers().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> {
                            User user = ctx.convert(e.getValue(), User.class);
                            return new ConversationResponseUsers()
                                    .user(user)
                                    .userId(user.getUserId());
                        }
                ));
        conversationResponse.setUsers(users);

        return conversationResponse;
    }

    @Override
    public GetConversationResponse toThrift(ConversationResponse value, ThriftConverterContext ctx) {
        GetConversationResponse getConversationResponse = new GetConversationResponse();
        List<dev.vality.damsel.messages.Conversation> conversationList = value.getConversations().stream()
                .map(conversation -> ctx.convert(conversation, dev.vality.damsel.messages.Conversation.class))
                .collect(Collectors.toList());
        getConversationResponse.setConversations(conversationList);

        Map<String, dev.vality.damsel.messages.User> users = value.getUsers().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> ctx.convert(e.getValue(), dev.vality.damsel.messages.User.class)
                ));
        getConversationResponse.setUsers(users);

        return getConversationResponse;
    }

}
