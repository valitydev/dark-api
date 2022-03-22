package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.*;
import org.springframework.stereotype.Component;

@Component
public class PropertyInfoDocumentTypeConverter implements
        ThriftConverter<PropertyInfoDocumentType, dev.vality.swag.questionary.model.PropertyInfoDocumentType>,
        SwagConverter<dev.vality.swag.questionary.model.PropertyInfoDocumentType, PropertyInfoDocumentType> {

    @Override
    public PropertyInfoDocumentType toThrift(dev.vality.swag.questionary.model.PropertyInfoDocumentType value,
                                             ThriftConverterContext ctx) {
        switch (value.getDocumentType()) {
            case LEASECONTRACT:
                return PropertyInfoDocumentType.lease_contract(new LeaseContract());
            case SUBLEASECONTRACT:
                return PropertyInfoDocumentType.sublease_contract(new SubleaseContract());
            case CERTIFICATEOFOWNERSHIP:
                return PropertyInfoDocumentType.certificate_of_ownership(new CertificateOfOwnership());
            case OTHERPROPERTYINFODOCUMENTTYPE:
                var swagOtherPropertyInfoDocumentType =
                        (dev.vality.swag.questionary.model.OtherPropertyInfoDocumentType) value;
                OtherPropertyInfoDocumentType otherPropertyInfoDocumentType = new OtherPropertyInfoDocumentType()
                        .setName(swagOtherPropertyInfoDocumentType.getName());
                return PropertyInfoDocumentType.other_property_info_document_type(otherPropertyInfoDocumentType);
            default:
                throw new IllegalArgumentException("Unknown propertyInfoDocument type: " + value.getDocumentType());
        }
    }


    @Override
    public dev.vality.swag.questionary.model.PropertyInfoDocumentType toSwag(PropertyInfoDocumentType value,
                                                                               SwagConverterContext ctx) {
        if (value.isSetLeaseContract()) {
            return new dev.vality.swag.questionary.model.LeaseContract();
        } else if (value.isSetSubleaseContract()) {
            return new dev.vality.swag.questionary.model.SubleaseContract();
        } else if (value.isSetCertificateOfOwnership()) {
            return new dev.vality.swag.questionary.model.CertificateOfOwnership();
        } else if (value.isSetOtherPropertyInfoDocumentType()) {
            var otherPropertyInfoDocumentType = new dev.vality.swag.questionary.model.OtherPropertyInfoDocumentType();
            otherPropertyInfoDocumentType.setName(value.getOtherPropertyInfoDocumentType().getName());
            return otherPropertyInfoDocumentType;
        } else {
            throw new IllegalArgumentException("Unknown propertyInfoDocument type: " + value.getClass().getName());
        }
    }
}
