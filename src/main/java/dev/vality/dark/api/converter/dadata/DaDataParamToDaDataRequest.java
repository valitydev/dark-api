package dev.vality.dark.api.converter.dadata;

import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.dark.api.util.ConverterUtils;
import dev.vality.questionary_proxy_aggr.dadata_api.DaDataEndpoint;
import dev.vality.questionary_proxy_aggr.dadata_api.DaDataRequest;
import dev.vality.swag.questionary_aggr_proxy.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DaDataParamToDaDataRequest implements ThriftConverter<DaDataRequestHolder, DaDataParams> {

    @Override
    public DaDataRequestHolder toThrift(DaDataParams daDataParams, ThriftConverterContext thriftConverterContext) {
        DaDataRequestHolder daDataRequestHolder = new DaDataRequestHolder();
        DaDataRequest daDataRequest = new DaDataRequest();
        daDataRequestHolder.setDaDataRequest(daDataRequest);
        switch (daDataParams.getRequest().getDaDataRequestType()) {
            case OKVEDQUERY:
                daDataRequestHolder
                        .setDaDataEndpoint(dev.vality.questionary_proxy_aggr.dadata_api.DaDataEndpoint.okved2);
                OkvedQuery swagOkvedQuery = ((OkvedQuery) daDataParams.getRequest());
                daDataRequest.setOkvedQuery(convertOkvedQuery(swagOkvedQuery));
                break;
            case FIOQUERY:
                daDataRequestHolder.setDaDataEndpoint(DaDataEndpoint.suggest_fio);
                FioQuery swagFioQuery = (FioQuery) daDataParams.getRequest();
                daDataRequest.setFioQuery(convertFioQuery(swagFioQuery));
                break;
            case BANKQUERY:
                daDataRequestHolder.setDaDataEndpoint(DaDataEndpoint.suggest_bank);
                BankQuery swagBankQuery = (BankQuery) daDataParams.getRequest();
                daDataRequest.setBankQuery(convertBankQuery(swagBankQuery));
                break;
            case PARTYQUERY:
                daDataRequestHolder.setDaDataEndpoint(DaDataEndpoint.suggest_party);
                PartyQuery swagPartyQuery = (PartyQuery) daDataParams.getRequest();
                daDataRequest.setPartyQuery(convertPartyQuery(swagPartyQuery));
                break;
            case FMSUNITQUERY:
                daDataRequestHolder.setDaDataEndpoint(DaDataEndpoint.suggest_fms_unit);
                FmsUnitQuery swagFmsUnitQuery = (FmsUnitQuery) daDataParams.getRequest();
                daDataRequest.setFmsUnitQuery(convertFmsUnitQuery(swagFmsUnitQuery));
                break;
            case ADDRESSQUERY:
                daDataRequestHolder.setDaDataEndpoint(DaDataEndpoint.suggest_address);
                AddressQuery swagAddressQuery = (AddressQuery) daDataParams.getRequest();
                daDataRequest.setAddressQuery(convertAddressQuery(swagAddressQuery));
                break;
            default:
                throw new IllegalArgumentException(
                        "Unknown endpoint: " + daDataParams.getRequest().getDaDataRequestType());
        }

        return daDataRequestHolder;
    }

    private dev.vality.questionary_proxy_aggr.dadata_fio.FioQuery convertFioQuery(FioQuery fioQuery) {
        var thriftFioQuery = new dev.vality.questionary_proxy_aggr.dadata_fio.FioQuery();
        thriftFioQuery.setQuery(fioQuery.getQuery());
        if (fioQuery.getCount() != null) {
            thriftFioQuery.setCount(fioQuery.getCount().byteValue());
        }
        if (fioQuery.getParts() != null) {
            thriftFioQuery.setParts(fioQuery.getParts());
        }
        if (fioQuery.getGender() == Gender.FEMALE) {
            thriftFioQuery.setGender(dev.vality.questionary_proxy_aggr.base_dadata.Gender.FEMALE);
        } else if (fioQuery.getGender() == Gender.MALE) {
            thriftFioQuery.setGender(dev.vality.questionary_proxy_aggr.base_dadata.Gender.MALE);
        } else if (fioQuery.getGender() == Gender.UNKNOWN) {
            thriftFioQuery.setGender(dev.vality.questionary_proxy_aggr.base_dadata.Gender.UNKNOWN);
        }
        return thriftFioQuery;
    }

    private dev.vality.questionary_proxy_aggr.dadata_okved2.OkvedQuery convertOkvedQuery(OkvedQuery okvedQuery) {
        var thriftOkvedQuery = new dev.vality.questionary_proxy_aggr.dadata_okved2.OkvedQuery();
        thriftOkvedQuery.setQuery(okvedQuery.getQuery());
        thriftOkvedQuery.setQueryType(convertQueryType(okvedQuery.getQueryType()));
        return thriftOkvedQuery;
    }

    private dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus convertOrgStatus(OrgStatus orgStatus) {
        switch (orgStatus) {
            case ACTIVE:
                return dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.ACTIVE;
            case LIQUIDATED:
                return dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.LIQUIDATED;
            case REORGANIZING:
                return dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.REORGANIZING;
            case LIQUIDATING:
                return dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus.LIQUIDATING;
            default:
                throw new IllegalArgumentException("Unknown orgStatus: " + orgStatus);
        }
    }

    private dev.vality.questionary_proxy_aggr.base_dadata.OrgType convertOrgType(OrgType orgType) {
        switch (orgType) {
            case LEGAL:
                return dev.vality.questionary_proxy_aggr.base_dadata.OrgType.LEGAL;
            case INDIVIDUAL:
                return dev.vality.questionary_proxy_aggr.base_dadata.OrgType.INDIVIDUAL;
            default:
                throw new IllegalArgumentException("Unknown orgType: " + orgType);
        }
    }

    private dev.vality.questionary_proxy_aggr.base_dadata.QueryType convertQueryType(QueryType queryType) {
        switch (queryType) {
            case BYIDENTIFIRE:
                return dev.vality.questionary_proxy_aggr.base_dadata.QueryType.BY_INDENTIFIRE;
            case FULLTEXTSEARCH:
                return dev.vality.questionary_proxy_aggr.base_dadata.QueryType.FULL_TEXT_SEARCH;
            default:
                throw new IllegalArgumentException("Unknown queryType: " + queryType);
        }
    }

    private dev.vality.questionary_proxy_aggr.dadata_address.BoundType convertBoundType(BoundType boundType) {
        switch (boundType) {
            case AREA:
                return dev.vality.questionary_proxy_aggr.dadata_address.BoundType.area;
            case CITY:
                return dev.vality.questionary_proxy_aggr.dadata_address.BoundType.city;
            case HOUSE:
                return dev.vality.questionary_proxy_aggr.dadata_address.BoundType.house;
            case REGION:
                return dev.vality.questionary_proxy_aggr.dadata_address.BoundType.region;
            case SETTLEMENT:
                return dev.vality.questionary_proxy_aggr.dadata_address.BoundType.settlement;
            case STREET:
                return dev.vality.questionary_proxy_aggr.dadata_address.BoundType.street;
            default:
                throw new IllegalArgumentException("Unknown boundType: " + boundType);
        }
    }

    private dev.vality.questionary_proxy_aggr.dadata_bank.BankQuery convertBankQuery(BankQuery swagBankQuery) {
        var thriftBankQuery = new dev.vality.questionary_proxy_aggr.dadata_bank.BankQuery();
        thriftBankQuery.setQuery(swagBankQuery.getQuery());
        if (swagBankQuery.getCount() != null) {
            thriftBankQuery.setCount(swagBankQuery.getCount().byteValue());
        }
        if (swagBankQuery.getStatus() != null) {
            List<dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus> thriftOrgStatusList =
                    swagBankQuery.getStatus().stream()
                            .map(this::convertOrgStatus)
                            .collect(Collectors.toList());
            thriftBankQuery.setStatus(thriftOrgStatusList);
        }
        if (swagBankQuery.getType() != null) {
            thriftBankQuery.setType(convertOrgType(swagBankQuery.getType()));
        }
        return thriftBankQuery;
    }

    private dev.vality.questionary_proxy_aggr.dadata_party.PartyQuery convertPartyQuery(PartyQuery swagPartyQuery) {
        var thriftPartyQuery = new dev.vality.questionary_proxy_aggr.dadata_party.PartyQuery();
        thriftPartyQuery.setQuery(swagPartyQuery.getQuery());
        if (swagPartyQuery.getCount() != null) {
            thriftPartyQuery.setCount(swagPartyQuery.getCount().byteValue());
        }
        if (swagPartyQuery.getStatus() != null) {
            List<dev.vality.questionary_proxy_aggr.base_dadata.OrgStatus> thriftOrgStatusList =
                    swagPartyQuery.getStatus().stream()
                            .map(this::convertOrgStatus)
                            .collect(Collectors.toList());
            thriftPartyQuery.setStatus(thriftOrgStatusList);
        }
        if (swagPartyQuery.getType() != null) {
            thriftPartyQuery.setType(convertOrgType(swagPartyQuery.getType()));
        }
        if (swagPartyQuery.getLocationsBoost() != null) {
            List<dev.vality.questionary_proxy_aggr.base_dadata.LocationBoostFilter> thriftLocationBoostFilters =
                    swagPartyQuery.getLocationsBoost().stream()
                            .map(this::convertLocationBoostFilter)
                            .collect(Collectors.toList());
            thriftPartyQuery.setLocationsBoost(thriftLocationBoostFilters);
        }
        if (swagPartyQuery.getLocations() != null) {
            List<dev.vality.questionary_proxy_aggr.base_dadata.LocationFilter> thriftLocationFilters =
                    swagPartyQuery.getLocations().stream()
                            .map(this::convertLocationFilter)
                            .collect(Collectors.toList());
            thriftPartyQuery.setLocations(thriftLocationFilters);
        }
        return thriftPartyQuery;
    }

    private dev.vality.questionary_proxy_aggr.base_dadata.LocationFilter convertLocationFilter(
            LocationFilter locationFilter) {
        var thriftLocationFilter = new dev.vality.questionary_proxy_aggr.base_dadata.LocationFilter();
        thriftLocationFilter.setKladrId(locationFilter.getKladrId());
        return thriftLocationFilter;
    }

    private dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitQuery convertFmsUnitQuery(
            FmsUnitQuery swagFmsUnitQuery) {
        var thriftFmsUnitQuery = new dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitQuery();
        thriftFmsUnitQuery.setQuery(swagFmsUnitQuery.getQuery());
        thriftFmsUnitQuery.setQueryType(convertQueryType(swagFmsUnitQuery.getQueryType()));
        if (swagFmsUnitQuery.getFilters() != null && !swagFmsUnitQuery.getFilters().isEmpty()) {
            List<dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitQueryFilter> thriftFmsUnitQueryFilters =
                    swagFmsUnitQuery.getFilters().stream()
                            .map(this::convertFmsUnitQuery)
                            .collect(Collectors.toList());
            thriftFmsUnitQuery.setFilters(thriftFmsUnitQueryFilters);
        }
        return thriftFmsUnitQuery;
    }

    private dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitQueryFilter convertFmsUnitQuery(
            FmsUnitQueryFilter fmsUnitQueryFilter) {
        var thriftFmsUnitQueryFilter = new dev.vality.questionary_proxy_aggr.dadata_fms_unit.FmsUnitQueryFilter();
        thriftFmsUnitQueryFilter.setRegionCode(fmsUnitQueryFilter.getRegionCode());
        thriftFmsUnitQueryFilter.setType(fmsUnitQueryFilter.getType());
        return thriftFmsUnitQueryFilter;
    }

    private dev.vality.questionary_proxy_aggr.dadata_address.AddressQuery convertAddressQuery(
            AddressQuery swagAddressQuery) {
        var thriftAddressQuery = new dev.vality.questionary_proxy_aggr.dadata_address.AddressQuery();
        thriftAddressQuery.setQuery(swagAddressQuery.getQuery());
        thriftAddressQuery.setRestrictValue(ConverterUtils.safeSetValue(swagAddressQuery.isRestrictValue()));
        if (swagAddressQuery.getToBound() != null) {
            thriftAddressQuery.setToBound(convertBoundType(swagAddressQuery.getToBound()));
        }
        if (swagAddressQuery.getFromBound() != null) {
            thriftAddressQuery.setFromBound(convertBoundType(swagAddressQuery.getFromBound()));
        }
        if (swagAddressQuery.getCount() != null) {
            thriftAddressQuery.setCount(swagAddressQuery.getCount().byteValue());
        }
        if (swagAddressQuery.getLocations() != null && !swagAddressQuery.getLocations().isEmpty()) {
            List<dev.vality.questionary_proxy_aggr.dadata_address.AddressLocationFilter>
                    thriftAddressLocationFilters = swagAddressQuery.getLocations().stream()
                    .map(this::convertAddressLocationFilter)
                    .collect(Collectors.toList());
            thriftAddressQuery.setLocations(thriftAddressLocationFilters);
        }
        if (swagAddressQuery.getLocationsBoost() != null && !swagAddressQuery.getLocationsBoost().isEmpty()) {
            List<dev.vality.questionary_proxy_aggr.base_dadata.LocationBoostFilter> thriftLocationBoostFilters =
                    swagAddressQuery.getLocationsBoost().stream()
                            .map(this::convertLocationBoostFilter)
                            .collect(Collectors.toList());
            thriftAddressQuery.setLocationsBoost(thriftLocationBoostFilters);
        }
        return thriftAddressQuery;
    }

    private dev.vality.questionary_proxy_aggr.base_dadata.LocationBoostFilter convertLocationBoostFilter(
            LocationBoostFilter locationBoostFilter) {
        var thriftLocationBoostFilter = new dev.vality.questionary_proxy_aggr.base_dadata.LocationBoostFilter();
        thriftLocationBoostFilter.setKladrId(locationBoostFilter.getKladrId());
        return thriftLocationBoostFilter;
    }

    private dev.vality.questionary_proxy_aggr.dadata_address.AddressLocationFilter convertAddressLocationFilter(
            AddressLocationFilter addressLocationFilter) {
        var thriftAddressLocationFilter =
                new dev.vality.questionary_proxy_aggr.dadata_address.AddressLocationFilter();
        thriftAddressLocationFilter.setCityFiasId(addressLocationFilter.getCityFiasId());
        thriftAddressLocationFilter.setCity(addressLocationFilter.getCity());
        thriftAddressLocationFilter.setKladrId(addressLocationFilter.getKladrId());
        thriftAddressLocationFilter.setAreaFiasId(addressLocationFilter.getAreaFiasId());
        thriftAddressLocationFilter.setRegion(addressLocationFilter.getRegion());
        thriftAddressLocationFilter.setRegionFiasId(addressLocationFilter.getRegionFiasId());
        thriftAddressLocationFilter.setSettlementFiasId(addressLocationFilter.getSettlementFiasId());
        thriftAddressLocationFilter.setStreetFiasId(addressLocationFilter.getStreetFiasId());
        return thriftAddressLocationFilter;
    }

}
