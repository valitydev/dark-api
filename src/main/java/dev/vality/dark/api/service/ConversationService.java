package dev.vality.dark.api.service;

import dev.vality.damsel.messages.*;
import dev.vality.dark.api.converter.SwagConvertManager;
import dev.vality.swag.messages.model.ConversationParam;
import dev.vality.swag.messages.model.ConversationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConversationService {

    private final MessageServiceSrv.Iface messageServiceClient;

    private final SwagConvertManager swagConvertManager;

    public void saveConversation(List<ConversationParam> conversationParams, User user) throws TException {
        String createdTime = Instant.now().toString();

        List<Conversation> conversationList = conversationParams.stream()
                .map(conversationParam -> getConversation(user, createdTime, conversationParam))
                .collect(Collectors.toList());

        messageServiceClient.saveConversations(conversationList, user);
    }

    public ConversationResponse getConversation(List<String> conversationIdList,
                                                dev.vality.swag.messages.model.ConversationStatus conversationStatus)
            throws TException {
        if (conversationStatus == null) {
            conversationStatus = dev.vality.swag.messages.model.ConversationStatus.ACTUAL;
        }
        var swagConversationFilter =
                new dev.vality.swag.messages.model.ConversationFilter().conversationStatus(conversationStatus);

        ConversationFilter conversationFilter =
                swagConvertManager.convertToThrift(swagConversationFilter, ConversationFilter.class);

        GetConversationResponse conversations =
                messageServiceClient.getConversations(conversationIdList, conversationFilter);

        return swagConvertManager.convertFromThrift(conversations, ConversationResponse.class);
    }

    private Conversation getConversation(User user, String createdTime, ConversationParam conversationParam) {
        Conversation conversation = new Conversation();
        conversation.setConversationId(conversationParam.getConversationId());
        List<Message> messageList = conversationParam.getMessages().stream()
                .map(
                        message -> new Message()
                                .setMessageId(message.getMessageId())
                                .setText(message.getText())
                                .setUserId(user.getUserId())
                                .setTimestamp(createdTime)
                )
                .collect(Collectors.toList());
        conversation.setMessages(messageList);
        conversation.setStatus(ConversationStatus.ACTUAL);
        return conversation;
    }
}
