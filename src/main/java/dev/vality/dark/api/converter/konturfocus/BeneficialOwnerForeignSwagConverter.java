package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.BeneficialOwnerForeign;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@SuppressWarnings("LineLength")
public class BeneficialOwnerForeignSwagConverter implements
        SwagConverter<BeneficialOwnerForeign, dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerForeign> {

    @Override
    public BeneficialOwnerForeign toSwag(
            dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerForeign value,
            SwagConverterContext ctx) {
        BeneficialOwnerForeign beneficialOwnerUl = new BeneficialOwnerForeign();
        beneficialOwnerUl.setFullName(value.getFullName());
        beneficialOwnerUl.setCountry(value.getCountry());
        beneficialOwnerUl.setIsAccurate(value.isIsAccurate());
        beneficialOwnerUl.setShare(BigDecimal.valueOf(value.getShare()));

        return beneficialOwnerUl;
    }

}
