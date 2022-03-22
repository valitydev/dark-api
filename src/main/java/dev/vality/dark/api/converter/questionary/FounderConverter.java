package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.Founder;
import dev.vality.swag.questionary.model.Founder.FounderTypeEnum;
import dev.vality.swag.questionary.model.IndividualPerson;
import dev.vality.swag.questionary.model.InternationalLegalEntityFounder;
import dev.vality.swag.questionary.model.RussianLegalEntityFounder;
import org.springframework.stereotype.Component;

@Component
public class FounderConverter implements
        ThriftConverter<Founder, dev.vality.swag.questionary.model.Founder>,
        SwagConverter<dev.vality.swag.questionary.model.Founder, Founder> {

    @Override
    public dev.vality.swag.questionary.model.Founder toSwag(Founder value, SwagConverterContext ctx) {
        if (value.isSetIndividualPersonFounder()) {
            IndividualPerson individualPerson = new IndividualPerson();
            individualPerson.setFio(value.getIndividualPersonFounder().getFio());
            individualPerson.setInn(value.getIndividualPersonFounder().getInn());
            individualPerson.setFounderType(FounderTypeEnum.INDIVIDUALPERSON);

            return individualPerson;
        } else if (value.isSetInternationalLegalEntityFounder()) {
            return new InternationalLegalEntityFounder()
                    .country(value.getInternationalLegalEntityFounder().getCountry())
                    .fullName(value.getInternationalLegalEntityFounder().getFullName())
                    .founderType(FounderTypeEnum.INTERNATIONALLEGALENTITYFOUNDER);
        } else if (value.isSetRussianLegalEntityFounder()) {
            return new RussianLegalEntityFounder()
                    .fullName(value.getRussianLegalEntityFounder().getFullName())
                    .inn(value.getRussianLegalEntityFounder().getInn())
                    .ogrn(value.getRussianLegalEntityFounder().getOgrn())
                    .founderType(FounderTypeEnum.RUSSIANLEGALENTITYFOUNDER);
        } else {
            throw new IllegalArgumentException("Unknown founder type: " + value.getClass().getName());
        }
    }

    @Override
    public Founder toThrift(dev.vality.swag.questionary.model.Founder value, ThriftConverterContext ctx) {
        Founder founder = new Founder();
        switch (value.getFounderType()) {
            case INDIVIDUALPERSON:
                var individualPerson = new dev.vality.questionary.IndividualPerson();
                individualPerson.setFio(((IndividualPerson) value).getFio());
                individualPerson.setInn(((IndividualPerson) value).getInn());

                founder.setIndividualPersonFounder(individualPerson);

                return founder;
            case INTERNATIONALLEGALENTITYFOUNDER:
                var internationalLegalEntityFounder = new dev.vality.questionary.InternationalLegalEntityFounder()
                        .setFullName(((InternationalLegalEntityFounder) value).getFullName())
                        .setCountry(((InternationalLegalEntityFounder) value).getCountry());

                founder.setInternationalLegalEntityFounder(internationalLegalEntityFounder);

                return founder;
            case RUSSIANLEGALENTITYFOUNDER:
                var russianLegalEntityFounder = new dev.vality.questionary.RussianLegalEntityFounder()
                        .setFullName(((RussianLegalEntityFounder) value).getFullName())
                        .setInn(((RussianLegalEntityFounder) value).getInn())
                        .setOgrn(((RussianLegalEntityFounder) value).getOgrn());

                founder.setRussianLegalEntityFounder(russianLegalEntityFounder);

                return founder;
            default:
                throw new IllegalArgumentException("Unknown founder type: " + value.getFounderType());
        }
    }

}
