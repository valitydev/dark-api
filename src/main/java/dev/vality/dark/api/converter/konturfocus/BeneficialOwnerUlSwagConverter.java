package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.BeneficialOwnerUl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@SuppressWarnings("LineLength")
public class BeneficialOwnerUlSwagConverter implements
        SwagConverter<BeneficialOwnerUl, dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerUl> {

    @Override
    public BeneficialOwnerUl toSwag(
            dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerUl value,
            SwagConverterContext ctx) {
        BeneficialOwnerUl beneficialOwnerUl = new BeneficialOwnerUl();
        beneficialOwnerUl.setFullName(value.getFullName());
        beneficialOwnerUl.setInn(value.getInn());
        beneficialOwnerUl.setIsAccurate(value.isIsAccurate());
        beneficialOwnerUl.setShare(BigDecimal.valueOf(value.getShare()));
        beneficialOwnerUl.setOgrn(value.getOgrn());

        return beneficialOwnerUl;
    }

}
