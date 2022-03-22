package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@SuppressWarnings("LineLength")
public class EgrDetailsLegalEntitySwagConverter implements
        SwagConverter<EgrDetailsLegalEntity, dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.EgrDetailsLegalEntity> {

    @Override
    public EgrDetailsLegalEntity toSwag(
            dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.EgrDetailsLegalEntity value,
            SwagConverterContext ctx) {
        EgrDetailsLegalEntity egrDetailsLegalEntity = new EgrDetailsLegalEntity();
        if (value.isSetActivities()) {
            egrDetailsLegalEntity.setActivities(ctx.convert(value.getActivities(), Activity.class));
        }
        if (value.isSetEgrRecords()) {
            List<EgrRecord> egrRecordList = value.getEgrRecords().stream()
                    .map(egrRecord -> ctx.convert(egrRecord, EgrRecord.class))
                    .collect(Collectors.toList());
            egrDetailsLegalEntity.setEgrRecords(egrRecordList);
        }
        egrDetailsLegalEntity.setFomsRegNumber(value.getFomsRegNumber());
        egrDetailsLegalEntity.setFssRegNumber(value.getFssRegNumber());
        if (value.isSetNalogRegBody()) {
            egrDetailsLegalEntity.setNalogRegBody(ctx.convert(value.getNalogRegBody(), NalogRegBody.class));
        }
        egrDetailsLegalEntity.setOkpo(value.getOkpo());
        egrDetailsLegalEntity.setPfrRegNumber(value.getPfrRegNumber());
        if (value.isSetRegBody()) {
            egrDetailsLegalEntity.setRegBody(ctx.convert(value.getRegBody(), RegBody.class));
        }
        if (value.isSetRegInfo()) {
            egrDetailsLegalEntity.setRegInfo(ctx.convert(value.getRegInfo(), RegInfo.class));
        }
        if (value.isSetFoundersFl()) {
            List<FounderFl> founderFlList = value.getFoundersFl().stream()
                    .map(founderFL -> ctx.convert(founderFL, FounderFl.class))
                    .collect(Collectors.toList());
            egrDetailsLegalEntity.setFoundersFl(founderFlList);
        }
        if (value.isSetFoundersUl()) {
            List<FounderUl> founderUlList = value.getFoundersUl().stream()
                    .map(founderUL -> ctx.convert(founderUL, FounderUl.class))
                    .collect(Collectors.toList());
            egrDetailsLegalEntity.setFoundersUl(founderUlList);
        }
        if (value.isSetPredecessors()) {
            List<FounderForeign> founderForeignList = value.getFoundersForeign().stream()
                    .map(founderForeign -> ctx.convert(founderForeign, FounderForeign.class))
                    .collect(Collectors.toList());
            egrDetailsLegalEntity.setFoundersForeign(founderForeignList);
        }
        if (value.isSetPredecessors()) {
            List<Predecessor> predecessorList = value.getPredecessors().stream()
                    .map(predecessor -> ctx.convert(predecessor, Predecessor.class))
                    .collect(Collectors.toList());
            egrDetailsLegalEntity.setPredecessor(predecessorList);
        }

        if (value.isSetShareholders()) {
            egrDetailsLegalEntity.setShareHolders(convertShareHolders(value.getShareholders(), ctx));
        }

        if (value.isSetStatedCapital()) {
            egrDetailsLegalEntity.setStatedCapital(convertStatedCapital(value.getStatedCapital()));
        }
        if (value.isSetSuccessors()) {
            List<Successor> successorList = value.getSuccessors().stream()
                    .map(this::convertSuccessor)
                    .collect(Collectors.toList());
            egrDetailsLegalEntity.setSuccessor(successorList);
        }

        egrDetailsLegalEntity.setHistory(ctx.convert(value.getHistory(), EgrDetailsHistory.class));

        return egrDetailsLegalEntity;
    }

    private ShareHolders convertShareHolders(
            dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.ShareHolders shareHolders,
            SwagConverterContext ctx) {
        ShareHolders swagShareHolders = new ShareHolders();
        swagShareHolders.setDate(shareHolders.getDate());
        if (shareHolders.isSetShareholdersFl()) {
            List<ShareHolderFl> shareHolderFlList = shareHolders.getShareholdersFl().stream()
                    .map(shareHolderFl -> ctx.convert(shareHolderFl, ShareHolderFl.class))
                    .collect(Collectors.toList());
            swagShareHolders.setShareHoldersFl(shareHolderFlList);
        }
        if (shareHolders.isSetShareholdersUl()) {
            List<ShareHolderUl> shareHolderUlList = shareHolders.getShareholdersUl().stream()
                    .map(shareHolderUL -> ctx.convert(shareHolderUL, ShareHolderUl.class))
                    .collect(Collectors.toList());
            swagShareHolders.setShareHoldersUl(shareHolderUlList);
        }
        if (shareHolders.isSetShareholdersOther()) {
            List<ShareHolderOther> shareHolderOtherList = shareHolders.getShareholdersOther().stream()
                    .map(shareHolderOther -> ctx.convert(shareHolderOther, ShareHolderOther.class))
                    .collect(Collectors.toList());
            swagShareHolders.setShareHoldersOther(shareHolderOtherList);
        }
        return swagShareHolders;
    }

    private StatedCapital convertStatedCapital(
            dev.vality.questionary_proxy_aggr.base_kontur_focus.StatedCapital statedCapital) {
        StatedCapital swagStatedCapital = new StatedCapital();
        swagStatedCapital.setDate(statedCapital.getDate());
        swagStatedCapital.setSum(statedCapital.getSum());
        return swagStatedCapital;
    }

    private Successor convertSuccessor(
            dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.Successor successor) {
        Successor swagSuccessor = new Successor();
        swagSuccessor.setDate(successor.getDate());
        swagSuccessor.setInn(successor.getInn());
        swagSuccessor.setName(successor.getName());
        swagSuccessor.setOgrn(successor.getOgrn());
        return swagSuccessor;
    }

}
