package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.MonthOperationCount;
import org.springframework.stereotype.Component;

@Component
public class MonthOperationCountConverter implements
        ThriftConverter<MonthOperationCount, dev.vality.swag.questionary.model.MonthOperationCount>,
        SwagConverter<dev.vality.swag.questionary.model.MonthOperationCount, MonthOperationCount> {

    @Override
    public dev.vality.swag.questionary.model.MonthOperationCount toSwag(MonthOperationCount value,
                                                                          SwagConverterContext ctx) {
        switch (value) {
            case lt_ten:
                return dev.vality.swag.questionary.model.MonthOperationCount.LTTEN;
            case gt_fifty:
                return dev.vality.swag.questionary.model.MonthOperationCount.GTFIFTY;
            case btw_ten_to_fifty:
                return dev.vality.swag.questionary.model.MonthOperationCount.BTWTENTOFIFTY;
            default:
                throw new IllegalArgumentException("Unknown monthOperationCount type: " + value);
        }
    }

    @Override
    public MonthOperationCount toThrift(dev.vality.swag.questionary.model.MonthOperationCount value,
                                        ThriftConverterContext ctx) {
        switch (value) {
            case BTWTENTOFIFTY:
                return MonthOperationCount.btw_ten_to_fifty;
            case GTFIFTY:
                return MonthOperationCount.gt_fifty;
            case LTTEN:
                return MonthOperationCount.lt_ten;
            default:
                throw new IllegalArgumentException("Unknown mothOperationCount type: " + value);
        }
    }

}
