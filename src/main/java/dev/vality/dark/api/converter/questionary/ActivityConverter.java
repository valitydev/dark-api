package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter implements
        ThriftConverter<Activity, dev.vality.swag.questionary.model.Activity>,
        SwagConverter<dev.vality.swag.questionary.model.Activity, Activity> {

    @Override
    public dev.vality.swag.questionary.model.Activity toSwag(Activity value, SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.Activity()
                .code(value.getCode())
                .description(value.getDescription());
    }

    @Override
    public Activity toThrift(dev.vality.swag.questionary.model.Activity value, ThriftConverterContext ctx) {
        Activity activity = new Activity();
        activity.setCode(value.getCode());
        activity.setDescription(value.getDescription());
        return activity;
    }

}
