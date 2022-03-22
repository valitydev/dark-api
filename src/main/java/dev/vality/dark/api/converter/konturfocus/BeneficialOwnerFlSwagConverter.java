package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.BeneficialOwnerFl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@SuppressWarnings("LineLength")
public class BeneficialOwnerFlSwagConverter implements
        SwagConverter<BeneficialOwnerFl, dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerFl> {

    @Override
    public BeneficialOwnerFl toSwag(
            dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerFl value,
            SwagConverterContext ctx) {
        BeneficialOwnerFl beneficialOwnerFl = new BeneficialOwnerFl();
        beneficialOwnerFl.setFio(value.getFio());
        beneficialOwnerFl.setInnfl(value.getInnfl());
        beneficialOwnerFl.setIsAccurate(value.isIsAccurate());
        beneficialOwnerFl.setShare(BigDecimal.valueOf(value.getShare()));

        return beneficialOwnerFl;
    }

}
