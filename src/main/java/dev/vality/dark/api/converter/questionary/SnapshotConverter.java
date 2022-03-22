package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.manage.Snapshot;
import dev.vality.swag.questionary.model.Questionary;
import org.springframework.stereotype.Component;

@Component
public class SnapshotConverter implements ThriftConverter<Snapshot, dev.vality.swag.questionary.model.Snapshot>,
        SwagConverter<dev.vality.swag.questionary.model.Snapshot, Snapshot> {

    @Override
    public dev.vality.swag.questionary.model.Snapshot toSwag(Snapshot value, SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.Snapshot()
                .version(String.valueOf(value.getVersion()))
                .questionary(ctx.convert(value.getQuestionary(), Questionary.class));
    }

    @Override
    public Snapshot toThrift(dev.vality.swag.questionary.model.Snapshot value, ThriftConverterContext ctx) {
        return new Snapshot()
                .setVersion(Long.parseLong(value.getVersion()))
                .setQuestionary(ctx.convert(value.getQuestionary(), dev.vality.questionary.manage.Questionary.class));
    }

}
