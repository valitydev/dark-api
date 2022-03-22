package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.BeneficialOwnerOther;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@SuppressWarnings("LineLength")
public class BeneficialOwnerOtherSwagConverter implements
        SwagConverter<BeneficialOwnerOther, dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerOther> {

    @Override
    public BeneficialOwnerOther toSwag(
            dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerOther value,
            SwagConverterContext ctx) {
        BeneficialOwnerOther beneficialOwnerOther = new BeneficialOwnerOther();
        beneficialOwnerOther.setFullname(value.getFullName());
        beneficialOwnerOther.setShare(BigDecimal.valueOf(value.getShare()));
        beneficialOwnerOther.setIsAccurate(value.isIsAccurate());

        return beneficialOwnerOther;
    }

}
