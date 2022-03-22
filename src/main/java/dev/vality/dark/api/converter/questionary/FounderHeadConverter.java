package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.Head;
import dev.vality.swag.questionary.model.FounderHead;
import dev.vality.swag.questionary.model.IndividualPerson;
import org.springframework.stereotype.Component;

@Component
public class FounderHeadConverter implements ThriftConverter<Head, FounderHead>, SwagConverter<FounderHead, Head> {

    @Override
    public FounderHead toSwag(Head value, SwagConverterContext ctx) {
        FounderHead founderHead = new FounderHead();
        if (value.isSetIndividualPerson()) {
            founderHead.setIndividualPerson(ctx.convert(value.getIndividualPerson(), IndividualPerson.class));
        }
        founderHead.setPosition(value.getPosition());
        return founderHead;
    }

    @Override
    public Head toThrift(FounderHead value, ThriftConverterContext ctx) {
        Head head = new Head();
        if (value.getIndividualPerson() != null) {
            head.setIndividualPerson(
                    ctx.convert(value.getIndividualPerson(), dev.vality.questionary.IndividualPerson.class));
        }
        head.setPosition(value.getPosition());
        return head;
    }

}
