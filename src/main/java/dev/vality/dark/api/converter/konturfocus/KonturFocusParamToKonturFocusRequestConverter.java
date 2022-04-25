package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.model.KonturFocusRequestHolder;
import dev.vality.questionary_proxy_aggr.kontur_focus_api.KonturFocusEndPoint;
import dev.vality.questionary_proxy_aggr.kontur_focus_api.KonturFocusRequest;
import dev.vality.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerQuery;
import dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.EgrDetailsQuery;
import dev.vality.questionary_proxy_aggr.kontur_focus_licences.LicencesQuery;
import dev.vality.questionary_proxy_aggr.kontur_focus_req.ReqQuery;
import dev.vality.swag.questionary_aggr_proxy.model.KonturFocusParams;
import org.springframework.stereotype.Component;

@Component
public class KonturFocusParamToKonturFocusRequestConverter
        implements ThriftConverter<KonturFocusRequestHolder, KonturFocusParams> {

    @Override
    public KonturFocusRequestHolder toThrift(KonturFocusParams konturFocusParams, ThriftConverterContext ctx) {
        KonturFocusRequestHolder konturFocusRequestHolder = new KonturFocusRequestHolder();
        KonturFocusRequest konturFocusRequest = null;
        switch (konturFocusParams.getRequest().getKonturFocusRequestType()) {
            case REQQUERY:
                konturFocusRequestHolder.setKonturFocusEndPoint(KonturFocusEndPoint.req);
                var swagReqQuery =
                        (dev.vality.swag.questionary_aggr_proxy.model.ReqQuery) konturFocusParams.getRequest();
                ReqQuery reqQuery = new ReqQuery();
                reqQuery.setInn(swagReqQuery.getInn());
                reqQuery.setOgrn(swagReqQuery.getOgrn());
                konturFocusRequest = new KonturFocusRequest();
                konturFocusRequest.setReqQuery(reqQuery);
                break;
            case EGRDETAILSQUERY:
                konturFocusRequestHolder.setKonturFocusEndPoint(KonturFocusEndPoint.egrDetails);
                var swagEgrDetails =
                        (dev.vality.swag.questionary_aggr_proxy.model.EgrDetailsQuery) konturFocusParams.getRequest();
                EgrDetailsQuery egrDetailsQuery = new EgrDetailsQuery();
                egrDetailsQuery.setInn(swagEgrDetails.getInn());
                egrDetailsQuery.setOgrn(swagEgrDetails.getOgrn());
                konturFocusRequest = new KonturFocusRequest();
                konturFocusRequest.setEgrDetailsQuery(egrDetailsQuery);
                break;
            case LICENCESQUERY:
                konturFocusRequestHolder.setKonturFocusEndPoint(KonturFocusEndPoint.licences);
                var swagLicenseQuery =
                        ((dev.vality.swag.questionary_aggr_proxy.model.LicencesQuery) konturFocusParams.getRequest());
                LicencesQuery licencesQuery = new LicencesQuery();
                licencesQuery.setInn(swagLicenseQuery.getInn());
                licencesQuery.setOgrn(swagLicenseQuery.getOgrn());
                konturFocusRequest = new KonturFocusRequest();
                konturFocusRequest.setLicencesQuery(licencesQuery);
                break;
            case BENEFICIALOWNERQUERY:
                konturFocusRequestHolder.setKonturFocusEndPoint(KonturFocusEndPoint.beneficial_owners);
                var swagBeneficialOwnerQuery =
                        (dev.vality.swag.questionary_aggr_proxy.model.BeneficialOwnerQuery) konturFocusParams
                                .getRequest();
                BeneficialOwnerQuery beneficialOwnerQuery = new BeneficialOwnerQuery();
                beneficialOwnerQuery.setInn(swagBeneficialOwnerQuery.getInn());
                beneficialOwnerQuery.setOgrn(swagBeneficialOwnerQuery.getOgrn());
                konturFocusRequest = new KonturFocusRequest();
                konturFocusRequest.setBeneficialOwnerQuery(beneficialOwnerQuery);
                break;
            default:
                throw new IllegalArgumentException(
                        "Unknown endpoint: " + konturFocusParams.getRequest().getKonturFocusRequestType());
        }

        konturFocusRequestHolder.setKonturFocusRequest(konturFocusRequest);

        return konturFocusRequestHolder;
    }

}
