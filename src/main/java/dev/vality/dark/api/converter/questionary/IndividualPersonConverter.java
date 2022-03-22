package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.IndividualPerson;
import org.springframework.stereotype.Component;

@Component
public class IndividualPersonConverter implements
        ThriftConverter<IndividualPerson, dev.vality.swag.questionary.model.IndividualPerson>,
        SwagConverter<dev.vality.swag.questionary.model.IndividualPerson, IndividualPerson> {

    @Override
    public dev.vality.swag.questionary.model.IndividualPerson toSwag(IndividualPerson value,
                                                                       SwagConverterContext ctx) {
        var individualPerson = new dev.vality.swag.questionary.model.IndividualPerson();
        individualPerson.setFio(value.getFio());
        individualPerson.setInn(value.getInn());
        return individualPerson;
    }

    @Override
    public IndividualPerson toThrift(dev.vality.swag.questionary.model.IndividualPerson value,
                                     ThriftConverterContext ctx) {
        IndividualPerson individualPerson = new IndividualPerson();
        individualPerson.setFio(value.getFio());
        individualPerson.setInn(value.getInn());
        return individualPerson;
    }

}
