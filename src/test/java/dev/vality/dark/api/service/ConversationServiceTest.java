package dev.vality.dark.api.service;

import dev.vality.damsel.messages.GetConversationResponse;
import dev.vality.damsel.messages.MessageServiceSrv;
import dev.vality.swag.messages.model.*;
import org.apache.thrift.TException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConversationServiceTest {

    @MockBean
    private MessageServiceSrv.Iface messageService;

    @Autowired
    private ConversationService conversationService;

    @Test
    public void saveConversationConverterTest() throws TException {
        ArgumentCaptor<List<dev.vality.damsel.messages.Conversation>> conversationCaptor =
                ArgumentCaptor.forClass((Class) List.class);
        ArgumentCaptor<dev.vality.damsel.messages.User> userCaptor =
                ArgumentCaptor.forClass((Class) List.class);
        SaveConversationParams saveConversationParams = saveConversationParams();
        dev.vality.damsel.messages.User testUser = buildUser();
        conversationService.saveConversation(saveConversationParams, testUser);
        verify(messageService).saveConversations(conversationCaptor.capture(), userCaptor.capture());
        List<dev.vality.damsel.messages.Conversation> conversationList = conversationCaptor.getValue();
        dev.vality.damsel.messages.User user = userCaptor.getValue();

        dev.vality.damsel.messages.Conversation conversation = conversationList.get(0);
        ConversationParam expectedConversation = saveConversationParams.get(0);

        dev.vality.damsel.messages.Message message = conversation.getMessages().get(0);
        MessageParam expectedMessage = expectedConversation.getMessages().get(0);

        Assert.assertSame(dev.vality.damsel.messages.ConversationStatus.ACTUAL, conversation.getStatus());

        Assert.assertEquals(expectedConversation.getConversationId(), conversation.getConversationId());
        Assert.assertEquals(testUser.getUserId(), message.getUserId());
        Assert.assertEquals(expectedMessage.getMessageId(), message.getMessageId());
        Assert.assertEquals(expectedMessage.getText(), message.getText());

        Assert.assertEquals(testUser.getUserId(), user.getUserId());
        Assert.assertEquals(testUser.getEmail(), user.getEmail());
        Assert.assertEquals(testUser.getFullname(), user.getFullname());
    }

    @Test
    public void getConversationConverterTest() throws TException {
        ArgumentCaptor<List<String>> listCaptor =
                ArgumentCaptor.forClass((Class) List.class);
        ArgumentCaptor<dev.vality.damsel.messages.ConversationFilter> conversationFilterCaptor =
                ArgumentCaptor.forClass((Class) List.class);
        List<String> conversationIds = Collections.singletonList("4254364");
        ConversationFilter swagConversationFilter =
                new ConversationFilter().conversationStatus(ConversationStatus.ACTUAL);
        GetConversationResponse getConversationResponse = conversationResponse();

        when(messageService.getConversations(anyList(), any(dev.vality.damsel.messages.ConversationFilter.class)))
                .thenReturn(getConversationResponse);
        ConversationResponse conversationResponse = conversationService.getConversation(conversationIds,
                swagConversationFilter.getConversationStatus());
        verify(messageService).getConversations(listCaptor.capture(), conversationFilterCaptor.capture());

        dev.vality.damsel.messages.ConversationFilter thriftConversationFilter = conversationFilterCaptor.getValue();

        Assert.assertEquals(thriftConversationFilter.getConversationStatus().toString().toLowerCase(),
                swagConversationFilter.getConversationStatus().toString().toLowerCase());

        dev.vality.damsel.messages.Conversation expectedConversation =
                getConversationResponse.getConversations().get(0);
        Conversation conversation = conversationResponse.getConversations().get(0);

        Assert.assertEquals(expectedConversation.getConversationId(), conversation.getConversationId());
        Assert.assertEquals(expectedConversation.getStatus().toString().toLowerCase(),
                conversation.getStatus().toString().toLowerCase());

        dev.vality.damsel.messages.Message expectedMessage = expectedConversation.getMessages().get(0);
        Message message = conversation.getMessages().get(0);

        Assert.assertEquals(expectedMessage.getMessageId(), message.getMessageId());
        Assert.assertEquals(expectedMessage.getText(), message.getText());
        Assert.assertEquals(expectedMessage.getTimestamp(), message.getTimestamp());
        Assert.assertEquals(expectedMessage.getUserId(), message.getUserId());

        dev.vality.damsel.messages.User expectedUser = getConversationResponse.getUsers().get("64");
        ConversationResponseUsers user = conversationResponse.getUsers().get("64");

        Assert.assertEquals(expectedUser.getUserId(), user.getUserId());
        Assert.assertEquals(expectedUser.getEmail(), user.getUser().getEmail());
        Assert.assertEquals(expectedUser.getFullname(), user.getUser().getFullName());
    }

    private SaveConversationParams saveConversationParams() {

        ConversationParam conversationParam = new ConversationParam();
        conversationParam.setConversationId("24134238");
        MessageParam messageParam = new MessageParam();
        messageParam.setMessageId("4324238");
        messageParam.setText("some test text");
        conversationParam.setMessages(Collections.singletonList(messageParam));

        SaveConversationParams saveConversationParams = new SaveConversationParams();
        saveConversationParams.add(conversationParam);

        return saveConversationParams;
    }

    private GetConversationResponse conversationResponse() {
        GetConversationResponse conversationResponse = new GetConversationResponse();
        dev.vality.damsel.messages.Conversation conversation = buildConversation();
        conversationResponse.setConversations(Collections.singletonList(conversation));
        dev.vality.damsel.messages.User user = buildUser();
        conversationResponse.setUsers(Map.of("64", user));

        return conversationResponse;
    }

    private dev.vality.damsel.messages.Conversation buildConversation() {
        dev.vality.damsel.messages.Conversation conversation = new dev.vality.damsel.messages.Conversation();
        conversation.setStatus(dev.vality.damsel.messages.ConversationStatus.OUTDATED);
        conversation.setConversationId("45");
        dev.vality.damsel.messages.Message message = buildMessage();
        conversation.setMessages(Collections.singletonList(message));

        return conversation;
    }

    private dev.vality.damsel.messages.Message buildMessage() {
        dev.vality.damsel.messages.Message message = new dev.vality.damsel.messages.Message();
        message.setMessageId("1");
        message.setUserId("64");
        message.setTimestamp("536432547");
        message.setText("Test text");

        return message;
    }

    private dev.vality.damsel.messages.User buildUser() {
        dev.vality.damsel.messages.User user = new dev.vality.damsel.messages.User();
        user.setUserId("64");
        user.setEmail("test@mail.com");
        user.setFullname("Test full name");

        return user;
    }

}
