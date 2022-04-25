package dev.vality.dark.api.converter.mesages;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.swag.messages.model.ConversationStatus;
import org.springframework.stereotype.Component;

@Component
public class ConversationStatusConverter
        implements SwagConverter<ConversationStatus, dev.vality.damsel.messages.ConversationStatus>,
        ThriftConverter<dev.vality.damsel.messages.ConversationStatus, ConversationStatus> {

    @Override
    public ConversationStatus toSwag(dev.vality.damsel.messages.ConversationStatus value, SwagConverterContext ctx) {
        switch (value) {
            case ACTUAL:
                return ConversationStatus.ACTUAL;
            case OUTDATED:
                return ConversationStatus.OUTDATED;
            default:
                throw new IllegalArgumentException("Unknown conversation status: " + value);
        }
    }

    @Override
    public dev.vality.damsel.messages.ConversationStatus toThrift(ConversationStatus value,
                                                                    ThriftConverterContext ctx) {
        switch (value) {
            case ACTUAL:
                return dev.vality.damsel.messages.ConversationStatus.ACTUAL;
            case OUTDATED:
                return dev.vality.damsel.messages.ConversationStatus.OUTDATED;
            default:
                throw new IllegalArgumentException("Unknown conversation status: " + value);
        }
    }

}
