package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.util.ConverterUtils;
import dev.vality.questionary.IndividualPersonCategories;
import org.springframework.stereotype.Component;

@Component
public class IndividualPersonCategoriesConverter implements
        ThriftConverter<IndividualPersonCategories, dev.vality.swag.questionary.model.IndividualPersonCategories>,
        SwagConverter<dev.vality.swag.questionary.model.IndividualPersonCategories, IndividualPersonCategories> {

    @Override
    public dev.vality.swag.questionary.model.IndividualPersonCategories toSwag(IndividualPersonCategories value,
                                                                                 SwagConverterContext ctx) {
        return new dev.vality.swag.questionary.model.IndividualPersonCategories()
                .behalfOfForeign(value.isBehalfOfForeign())
                .beneficialOwner(value.isBeneficialOwner())
                .foreignPublicPerson(value.isForeignPublicPerson())
                .foreignRelativePerson(value.isForeignRelativePerson())
                .hasRepresentative(value.isHasRepresentative())
                .worldwideOrgPublicPerson(value.isWorldwideOrgPublicPerson());
    }

    @Override
    public IndividualPersonCategories toThrift(dev.vality.swag.questionary.model.IndividualPersonCategories value,
                                               ThriftConverterContext ctx) {
        return new IndividualPersonCategories()
                .setBehalfOfForeign(ConverterUtils.safeSetValue(value.isBehalfOfForeign()))
                .setBeneficialOwner(ConverterUtils.safeSetValue(value.isBeneficialOwner()))
                .setForeignPublicPerson(ConverterUtils.safeSetValue(value.isForeignPublicPerson()))
                .setForeignRelativePerson(ConverterUtils.safeSetValue(value.isForeignRelativePerson()))
                .setHasRepresentative(ConverterUtils.safeSetValue(value.isHasRepresentative()))
                .setWorldwideOrgPublicPerson(ConverterUtils.safeSetValue(value.isWorldwideOrgPublicPerson()));
    }

}
