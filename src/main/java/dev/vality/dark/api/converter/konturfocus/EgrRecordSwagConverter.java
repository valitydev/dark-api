package dev.vality.dark.api.converter.konturfocus;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.swag.questionary_aggr_proxy.model.Certificate;
import dev.vality.swag.questionary_aggr_proxy.model.EgrRecord;
import dev.vality.swag.questionary_aggr_proxy.model.RecordDocument;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EgrRecordSwagConverter
        implements SwagConverter<EgrRecord, dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.EgrRecord> {

    @Override
    public EgrRecord toSwag(dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.EgrRecord value,
                            SwagConverterContext ctx) {
        EgrRecord swagEgrRecord = new EgrRecord();
        swagEgrRecord.setDate(value.getDate());
        swagEgrRecord.setGrn(value.getGrn());
        swagEgrRecord.setInvalid(value.isInvalid());
        swagEgrRecord.setName(value.getName());
        swagEgrRecord.setRegCode(value.getRegCode());
        swagEgrRecord.setRegName(value.getRegName());

        if (value.isSetCertificates()) {
            List<Certificate> certificateList = value.getCertificates().stream()
                    .map(this::convertCertificate)
                    .collect(Collectors.toList());
            swagEgrRecord.setCertificates(certificateList);
        }

        if (value.isSetDocuments()) {
            List<RecordDocument> recordDocumentList = value.getDocuments().stream()
                    .map(this::convertRecordDocument)
                    .collect(Collectors.toList());
            swagEgrRecord.setDocuments(recordDocumentList);
        }

        return swagEgrRecord;
    }

    private Certificate convertCertificate(
            dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.Certificate certificate) {
        Certificate swagCertificate = new Certificate();
        swagCertificate.setDate(certificate.getDate());
        swagCertificate.setSerialNumber(certificate.getSerialNumber());
        return swagCertificate;
    }

    private RecordDocument convertRecordDocument(
            dev.vality.questionary_proxy_aggr.kontur_focus_egr_details.RecordDocument recordDocument) {
        RecordDocument swagRecordDocument = new RecordDocument();
        swagRecordDocument.setDate(recordDocument.getDate());
        swagRecordDocument.setName(recordDocument.getName());
        return swagRecordDocument;
    }

}
