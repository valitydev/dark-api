package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.BusinessReputation;
import org.springframework.stereotype.Component;

@Component
public class BusinessReputationConverter implements
        ThriftConverter<BusinessReputation, dev.vality.swag.questionary.model.BusinessReputation>,
        SwagConverter<dev.vality.swag.questionary.model.BusinessReputation, BusinessReputation> {

    @Override
    public dev.vality.swag.questionary.model.BusinessReputation toSwag(BusinessReputation value,
                                                                         SwagConverterContext ctx) {
        switch (value) {
            case no_reviews:
                return dev.vality.swag.questionary.model.BusinessReputation.NOREVIEWS;
            case provide_reviews:
                return dev.vality.swag.questionary.model.BusinessReputation.PROVIDEREVIEWS;
            default:
                throw new IllegalArgumentException("Unknown businessReputation type: " + value);
        }
    }

    @Override
    public BusinessReputation toThrift(dev.vality.swag.questionary.model.BusinessReputation value,
                                       ThriftConverterContext ctx) {
        switch (value) {
            case PROVIDEREVIEWS:
                return BusinessReputation.provide_reviews;
            case NOREVIEWS:
                return BusinessReputation.no_reviews;
            default:
                throw new IllegalArgumentException("Unknown businessReputation type: " + value);
        }
    }

}
