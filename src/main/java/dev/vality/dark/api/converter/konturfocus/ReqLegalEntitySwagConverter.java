package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReqLegalEntitySwagConverter
        implements SwagConverter<ReqLegalEntity, dev.vality.questionary_proxy_aggr.kontur_focus_req.ReqLegalEntity> {

    @Override
    public ReqLegalEntity toSwag(dev.vality.questionary_proxy_aggr.kontur_focus_req.ReqLegalEntity value,
                                 SwagConverterContext ctx) {
        ReqLegalEntity swagReqLegalEntity = new ReqLegalEntity()
                .kpp(value.getKpp())
                .okato(value.getOkato())
                .okfs(value.getOkfs())
                .okogu(value.getOkogu())
                .okopf(value.getOkopf())
                .okpo(value.getOkpo())
                .oktmo(value.getOktmo())
                .opf(value.getOpf())
                .dissolutionDate(value.getDissolutionDate())
                .registrationDate(value.getRegistrationDate());
        if (value.isSetStatus()) {
            swagReqLegalEntity.setStatus(convertLegalEntityStatusDetail(value.getStatus()));
        }
        if (value.isSetBranches()) {
            List<Branch> swagBranchList = value.getBranches().stream()
                    .map(branch -> ctx.convert(branch, Branch.class))
                    .collect(Collectors.toList());
            swagReqLegalEntity.setBranches(swagBranchList);
        }
        if (value.isSetHeads()) {
            List<Head> swagHeadList = value.getHeads().stream()
                    .map(head -> ctx.convert(head, Head.class))
                    .collect(Collectors.toList());
            swagReqLegalEntity.setHeads(swagHeadList);
        }

        if (value.isSetLegalName()) {
            swagReqLegalEntity.setLegalName(ctx.convert(value.getLegalName(), LegalName.class));
        }

        if (value.isSetLegalAddress()) {
            swagReqLegalEntity.setLegalAddress(ctx.convert(value.getLegalAddress(), LegalAddress.class));
        }

        if (value.isSetManagementCompanies()) {
            List<ManagementCompany> swagManagementCompanies = value.getManagementCompanies().stream()
                    .map(managementCompany -> ctx.convert(managementCompany, ManagementCompany.class))
                    .collect(Collectors.toList());
            swagReqLegalEntity.setManagementCompanies(swagManagementCompanies);
        }

        if (value.isSetHistory()) {
            swagReqLegalEntity.setHistory(ctx.convert(value.getHistory(), ReqHistory.class));
        }

        return swagReqLegalEntity;
    }

    private LegalEntityStatusDetail convertLegalEntityStatusDetail(
            dev.vality.questionary_proxy_aggr.kontur_focus_req.LegalEntityStatusDetail legalEntityStatusDetail) {
        LegalEntityStatusDetail swagLegalEntityStatusDetail = new LegalEntityStatusDetail();
        swagLegalEntityStatusDetail.setStatus(legalEntityStatusDetail.getStatus());
        swagLegalEntityStatusDetail.setDate(legalEntityStatusDetail.getDate());
        swagLegalEntityStatusDetail.setDissolved(legalEntityStatusDetail.isDissolved());
        swagLegalEntityStatusDetail.setDissolving(legalEntityStatusDetail.isDissolving());
        swagLegalEntityStatusDetail.setReorganizing(legalEntityStatusDetail.isReorganizing());
        return swagLegalEntityStatusDetail;
    }

}
