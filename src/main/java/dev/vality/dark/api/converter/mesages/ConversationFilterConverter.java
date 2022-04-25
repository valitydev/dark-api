package dev.vality.dark.api.converter.mesages;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.messages.model.ConversationFilter;
import dev.vality.swag.messages.model.ConversationStatus;
import org.springframework.stereotype.Component;

@Component
public class ConversationFilterConverter
        implements SwagConverter<ConversationFilter, dev.vality.damsel.messages.ConversationFilter>,
        ThriftConverter<dev.vality.damsel.messages.ConversationFilter, ConversationFilter> {

    @Override
    public ConversationFilter toSwag(dev.vality.damsel.messages.ConversationFilter value, SwagConverterContext ctx) {
        ConversationFilter conversationFilter = new ConversationFilter();
        conversationFilter.setConversationStatus(ctx.convert(value.getConversationStatus(), ConversationStatus.class));

        return conversationFilter;
    }

    @Override
    public dev.vality.damsel.messages.ConversationFilter toThrift(ConversationFilter value,
                                                                    ThriftConverterContext ctx) {
        dev.vality.damsel.messages.ConversationFilter conversationFilter =
                new dev.vality.damsel.messages.ConversationFilter();
        conversationFilter.setConversationStatus(
                ctx.convert(value.getConversationStatus(), dev.vality.damsel.messages.ConversationStatus.class));

        return conversationFilter;
    }

}
