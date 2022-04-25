package dev.vality.dark.api.service;

import dev.vality.damsel.questionary_proxy_aggr.*;
import dev.vality.dark.api.converter.SwagConvertManager;
import dev.vality.dark.api.converter.dadata.DaDataRequestHolder;
import dev.vality.dark.api.model.KonturFocusRequestHolder;
import dev.vality.swag.questionary_aggr_proxy.model.DaDataParams;
import dev.vality.swag.questionary_aggr_proxy.model.DaDataResponse;
import dev.vality.swag.questionary_aggr_proxy.model.KonturFocusParams;
import dev.vality.swag.questionary_aggr_proxy.model.KonturFocusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionaryAggrProxyService {

    private final QuestionaryAggrProxyHandlerSrv.Iface questionaryAggrProxyClient;

    private final SwagConvertManager swagConvertManager;

    public KonturFocusResponse requestKonturFocus(KonturFocusParams konturFocusParams)
            throws TException {
        KonturFocusRequestHolder konturFocusRequestHolder =
                swagConvertManager.convertToThrift(konturFocusParams, KonturFocusRequestHolder.class);

        var thriftKonturFocusResponse = questionaryAggrProxyClient.requestKonturFocus(
                konturFocusRequestHolder.getKonturFocusRequest(), konturFocusRequestHolder.getKonturFocusEndPoint()
        );

        return swagConvertManager.convertFromThrift(thriftKonturFocusResponse, KonturFocusResponse.class);
    }

    public DaDataResponse requestDaData(DaDataParams daDataParams)
            throws TException {
        DaDataRequestHolder daDataRequestHolder =
                swagConvertManager.convertToThrift(daDataParams, DaDataRequestHolder.class);

        var thriftDaDataResponse = questionaryAggrProxyClient.requestDaData(
                daDataRequestHolder.getDaDataRequest(),
                daDataRequestHolder.getDaDataEndpoint()
        );

        return swagConvertManager.convertFromThrift(thriftDaDataResponse, DaDataResponse.class);
    }
}
