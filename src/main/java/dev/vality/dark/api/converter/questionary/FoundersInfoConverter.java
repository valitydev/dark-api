package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.Head;
import dev.vality.swag.questionary.model.Founder;
import dev.vality.swag.questionary.model.FounderHead;
import dev.vality.swag.questionary.model.FoundersInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoundersInfoConverter implements
        ThriftConverter<dev.vality.questionary.FoundersInfo, FoundersInfo>,
        SwagConverter<FoundersInfo, dev.vality.questionary.FoundersInfo> {

    @Override
    public FoundersInfo toSwag(dev.vality.questionary.FoundersInfo value, SwagConverterContext ctx) {
        FoundersInfo foundersInfo = new FoundersInfo();

        if (value.isSetFounders()) {
            List<Founder> founderList = value.getFounders().stream()
                    .map(founder -> ctx.convert(founder, Founder.class))
                    .collect(Collectors.toList());
            foundersInfo.setFounders(founderList);
        }

        if (value.isSetHeads()) {
            List<FounderHead> founderHeadList = value.getHeads().stream()
                    .map(head -> ctx.convert(head, FounderHead.class))
                    .collect(Collectors.toList());

            foundersInfo.setHeads(founderHeadList);
        }

        if (value.isSetLegalOwner()) {
            FounderHead founderHead = ctx.convert(value.getLegalOwner(), FounderHead.class);
            foundersInfo.setLegalOwner(founderHead);
        }

        return foundersInfo;
    }

    @Override
    public dev.vality.questionary.FoundersInfo toThrift(FoundersInfo value, ThriftConverterContext ctx) {
        var foundersInfo = new dev.vality.questionary.FoundersInfo();

        if (value.getFounders() != null) {
            List<dev.vality.questionary.Founder> founderList = value.getFounders().stream()
                    .map(founder -> ctx.convert(founder, dev.vality.questionary.Founder.class))
                    .collect(Collectors.toList());
            foundersInfo.setFounders(founderList);
        }

        if (value.getHeads() != null) {
            List<Head> founderHeadList = value.getHeads().stream()
                    .map(founderHead -> ctx.convert(founderHead, Head.class))
                    .collect(Collectors.toList());
            foundersInfo.setHeads(founderHeadList);
        }

        if (value.getLegalOwner() != null) {
            foundersInfo.setLegalOwner(ctx.convert(value.getLegalOwner(), Head.class));
        }

        return foundersInfo;
    }

}
