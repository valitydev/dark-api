package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.MonthOperationSum;
import org.springframework.stereotype.Component;

@Component
public class MonthOperationSumConverter implements
        ThriftConverter<MonthOperationSum, dev.vality.swag.questionary.model.MonthOperationSum>,
        SwagConverter<dev.vality.swag.questionary.model.MonthOperationSum, MonthOperationSum> {

    @Override
    public dev.vality.swag.questionary.model.MonthOperationSum toSwag(MonthOperationSum value,
                                                                        SwagConverterContext ctx) {
        switch (value) {
            case gt_one_million:
                return dev.vality.swag.questionary.model.MonthOperationSum.GTONEMILLION;
            case lt_five_hundred_thousand:
                return dev.vality.swag.questionary.model.MonthOperationSum.LTFIVEHUNDREDTHOUSAND;
            case btw_five_hundred_thousand_to_one_million:
                return dev.vality.swag.questionary.model.MonthOperationSum.BTWFIVEHUNDREDTHOUSANDTOONEMILLION;
            default:
                throw new IllegalArgumentException("Unknown monthOperationSum: " + value);
        }
    }

    @Override
    public MonthOperationSum toThrift(dev.vality.swag.questionary.model.MonthOperationSum value,
                                      ThriftConverterContext ctx) {
        switch (value) {
            case GTONEMILLION:
                return MonthOperationSum.gt_one_million;
            case LTFIVEHUNDREDTHOUSAND:
                return MonthOperationSum.lt_five_hundred_thousand;
            case BTWFIVEHUNDREDTHOUSANDTOONEMILLION:
                return MonthOperationSum.btw_five_hundred_thousand_to_one_million;
            default:
                throw new IllegalArgumentException("Unknown monthOperationSum: " + value);
        }
    }

}
