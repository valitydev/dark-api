package dev.vality.dark.api.utils;

import dev.vality.file.storage.base.Residence;
import dev.vality.geck.serializer.kit.mock.MockTBaseProcessor;
import dev.vality.geck.serializer.kit.tbase.TBaseHandler;
import dev.vality.swag.questionary.model.*;
import io.github.benas.randombeans.api.EnhancedRandom;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.thrift.TBase;

import java.util.Collections;

import static dev.vality.swag.questionary.model.LegalEntity.LegalEntityTypeEnum.INTERNATIONALLEGALENTITY;

@RequiredArgsConstructor
public class QuestionaryTestData {

    private final MockTBaseProcessor mockTBaseProcessor;

    public dev.vality.questionary.manage.QuestionaryParams createIndividualEntityQuestionaryThrift() {
        var bankAccount = new dev.vality.questionary.BankAccount();
        bankAccount.setInternationalBankAccount(createTestIntBankAccount());

        var shopInfo = new dev.vality.questionary.ShopInfo();
        shopInfo = fillTBaseObject(shopInfo, dev.vality.questionary.ShopInfo.class);

        var contactInfo = new dev.vality.questionary.ContactInfo();
        contactInfo = fillTBaseObject(contactInfo, dev.vality.questionary.ContactInfo.class);

        var individualEntity = new dev.vality.questionary.IndividualEntity();
        var russianIndividualEntity = new dev.vality.questionary.RussianIndividualEntity();
        russianIndividualEntity =
                fillTBaseObject(russianIndividualEntity, dev.vality.questionary.RussianIndividualEntity.class);
        individualEntity.setRussianIndividualEntity(russianIndividualEntity);

        var questionaryData = new dev.vality.questionary.manage.QuestionaryData();
        questionaryData.setBankAccount(bankAccount);
        questionaryData.setContactInfo(contactInfo);
        questionaryData.setShopInfo(shopInfo);
        questionaryData.setContractor(dev.vality.questionary.Contractor.individual_entity(individualEntity));

        var questionaryParams = new dev.vality.questionary.manage.QuestionaryParams();
        questionaryParams.setId("123456");
        questionaryParams.setOwnerId("12413");
        questionaryParams.setPartyId("12345");
        questionaryParams.setData(questionaryData);
        return questionaryParams;
    }

    public dev.vality.questionary.manage.QuestionaryParams createInternationalLegalEntityQuestionaryThrift() {
        var bankAccount = new dev.vality.questionary.BankAccount();
        bankAccount.setInternationalBankAccount(createTestIntBankAccount());

        var shopInfo = new dev.vality.questionary.ShopInfo();
        shopInfo = fillTBaseObject(shopInfo, dev.vality.questionary.ShopInfo.class);

        var contactInfo = new dev.vality.questionary.ContactInfo();
        contactInfo = fillTBaseObject(contactInfo, dev.vality.questionary.ContactInfo.class);

        var legalEntity = new dev.vality.questionary.LegalEntity();
        var internationalLegalEntity = new dev.vality.questionary.InternationalLegalEntity();
        internationalLegalEntity =
                fillTBaseObject(internationalLegalEntity, dev.vality.questionary.InternationalLegalEntity.class);
        legalEntity.setInternationalLegalEntity(internationalLegalEntity);

        var questionaryData = new dev.vality.questionary.manage.QuestionaryData();
        questionaryData.setBankAccount(bankAccount);
        questionaryData.setContactInfo(contactInfo);
        questionaryData.setShopInfo(shopInfo);
        questionaryData.setContractor(dev.vality.questionary.Contractor.legal_entity(legalEntity));

        var questionaryParams = new dev.vality.questionary.manage.QuestionaryParams();
        questionaryParams.setId("123456");
        questionaryParams.setOwnerId("12413");
        questionaryParams.setPartyId("12345");
        questionaryParams.setData(questionaryData);
        return questionaryParams;
    }

    public dev.vality.questionary.manage.QuestionaryParams createLegalEntityQuestionaryThrift() {
        var russianBankAccount = new dev.vality.questionary.RussianBankAccount();
        russianBankAccount = fillTBaseObject(russianBankAccount, dev.vality.questionary.RussianBankAccount.class);

        var bankAccount = new dev.vality.questionary.BankAccount();
        bankAccount.setRussianBankAccount(russianBankAccount);

        var shopInfo = new dev.vality.questionary.ShopInfo();
        shopInfo = fillTBaseObject(shopInfo, dev.vality.questionary.ShopInfo.class);

        var contactInfo = new dev.vality.questionary.ContactInfo();
        contactInfo = fillTBaseObject(contactInfo, dev.vality.questionary.ContactInfo.class);

        var russianLegalEntity = new dev.vality.questionary.RussianLegalEntity();
        russianLegalEntity = fillTBaseObject(russianLegalEntity, dev.vality.questionary.RussianLegalEntity.class);

        var legalEntity = new dev.vality.questionary.LegalEntity();
        legalEntity.setRussianLegalEntity(russianLegalEntity);

        var questionaryData = new dev.vality.questionary.manage.QuestionaryData();
        questionaryData.setBankAccount(bankAccount);
        questionaryData.setShopInfo(shopInfo);
        questionaryData.setContactInfo(contactInfo);
        questionaryData.setContractor(dev.vality.questionary.Contractor.legal_entity(legalEntity));

        var questionaryParams = new dev.vality.questionary.manage.QuestionaryParams();
        questionaryParams.setId("123456");
        questionaryParams.setOwnerId("12413");
        questionaryParams.setPartyId("12345");
        questionaryParams.setData(questionaryData);
        return questionaryParams;
    }

    public QuestionaryParams createIndividualEntityQuestionarySwag() {
        QuestionaryParams questionaryParams = EnhancedRandom.random(QuestionaryParams.class);
        questionaryParams.setVersion("0");
        IndividualEntityContractor individualEntityContractor = new IndividualEntityContractor();
        individualEntityContractor.setContractorType(Contractor.ContractorTypeEnum.INDIVIDUALENTITYCONTRACTOR);

        RussianIndividualEntity russianIndividualEntity = EnhancedRandom.random(RussianIndividualEntity.class);
        russianIndividualEntity.setIdentityDocument(
                EnhancedRandom.random(RussianDomesticPassport.class)
                        .identityDocumentType(IdentityDocument.IdentityDocumentTypeEnum.RUSSIANDOMESTICPASSPORT));

        IndividualRegistrationInfo individualRegistrationInfo = EnhancedRandom.random(IndividualRegistrationInfo.class);
        individualRegistrationInfo
                .setRegistrationInfoType(RegistrationInfo.RegistrationInfoTypeEnum.INDIVIDUALREGISTRATIONINFO);
        russianIndividualEntity.setRegistrationInfo(individualRegistrationInfo);

        IndividualResidencyInfo individualResidencyInfo = EnhancedRandom.random(IndividualResidencyInfo.class);
        individualResidencyInfo.setResidencyInfoType(ResidencyInfo.ResidencyInfoTypeEnum.INDIVIDUALRESIDENCYINFO);
        russianIndividualEntity.setResidencyInfo(individualResidencyInfo);

        var russianBankAccount = EnhancedRandom.random(dev.vality.swag.questionary.model.RussianBankAccount.class);
        russianBankAccount.setBankAccountType(BankAccount.BankAccountTypeEnum.RUSSIANBANKACCOUNT);
        russianIndividualEntity.getAdditionalInfo().setBankAccount(russianBankAccount);

        russianIndividualEntity.getAdditionalInfo().setFinancialPosition(
                Collections.singletonList(
                        new AnnualFinancialStatements().financialPositionType(
                                FinancialPosition.FinancialPositionTypeEnum.ANNUALFINANCIALSTATEMENTS)));

        russianIndividualEntity.getAdditionalInfo().setBusinessInfo(
                Collections.singletonList(
                        new AnotherBusiness().description("test")
                                .businessInfoType(BusinessInfo.BusinessInfoTypeEnum.ANOTHERBUSINESS)));

        WithoutChiefAccountingOrganization withoutChiefAccountingOrganization =
                new WithoutChiefAccountingOrganization();
        withoutChiefAccountingOrganization
                .setAccountantInfoType(AccountantInfo.AccountantInfoTypeEnum.WITHOUTCHIEFACCOUNTINGORGANIZATION);
        withoutChiefAccountingOrganization.setInn("test inn");
        russianIndividualEntity.getAdditionalInfo().setAccountantInfo(withoutChiefAccountingOrganization);

        BeneficialOwner beneficialOwner = EnhancedRandom.random(BeneficialOwner.class);
        beneficialOwner.setResidencyInfo(EnhancedRandom.random(IndividualResidencyInfo.class)
                .residencyInfoType(ResidencyInfo.ResidencyInfoTypeEnum.INDIVIDUALRESIDENCYINFO));
        beneficialOwner.setIdentityDocument(EnhancedRandom.random(RussianDomesticPassport.class)
                .identityDocumentType(IdentityDocument.IdentityDocumentTypeEnum.RUSSIANDOMESTICPASSPORT));
        beneficialOwner.setRussianPrivateEntity(EnhancedRandom.random(RussianPrivateEntity.class));
        russianIndividualEntity.setBeneficialOwners(Collections.singletonList(beneficialOwner));

        russianIndividualEntity.setPropertyInfoDocumentType(EnhancedRandom.random(OtherPropertyInfoDocumentType.class)
                .documentType(PropertyInfoDocumentType.DocumentTypeEnum.OTHERPROPERTYINFODOCUMENTTYPE));

        individualEntityContractor.setIndividualEntity(russianIndividualEntity);

        questionaryParams.getData().setContractor(individualEntityContractor);
        questionaryParams.getData().setBankAccount(russianBankAccount);
        questionaryParams.getData().getShopInfo().setLocation(
                new ShopLocationUrl().url("testUrl").locationType(ShopLocation.LocationTypeEnum.SHOPLOCATIONURL));

        return questionaryParams;
    }

    public QuestionaryParams createLegalEntityQuestionarySwag() {
        QuestionaryParams questionaryParams = EnhancedRandom.random(QuestionaryParams.class);
        questionaryParams.setVersion("0");
        questionaryParams.getData().setShopInfo(
                EnhancedRandom.random(ShopInfo.class)
                        .location(EnhancedRandom.random(ShopLocationUrl.class)
                                .locationType(ShopLocation.LocationTypeEnum.SHOPLOCATIONURL)));

        LegalEntityContractor legalEntityContractor = new LegalEntityContractor();
        legalEntityContractor.setContractorType(Contractor.ContractorTypeEnum.LEGALENTITYCONTRACTOR);
        RussianLegalEntity russianLegalEntity = EnhancedRandom.random(RussianLegalEntity.class);
        russianLegalEntity.setLegalEntityType(LegalEntity.LegalEntityTypeEnum.RUSSIANLEGALENTITY);
        russianLegalEntity.setRegistrationInfo(EnhancedRandom.random(LegalRegistrationInfo.class)
                .registrationInfoType(RegistrationInfo.RegistrationInfoTypeEnum.LEGALREGISTRATIONINFO));
        russianLegalEntity.setResidencyInfo(EnhancedRandom.random(LegalResidencyInfo.class)
                .residencyInfoType(ResidencyInfo.ResidencyInfoTypeEnum.LEGALRESIDENCYINFO));
        russianLegalEntity.getLegalOwnerInfo().setIdentityDocument(EnhancedRandom.random(RussianDomesticPassport.class)
                .identityDocumentType(IdentityDocument.IdentityDocumentTypeEnum.RUSSIANDOMESTICPASSPORT));
        var russianBankAccount = EnhancedRandom.random(dev.vality.swag.questionary.model.RussianBankAccount.class);
        russianBankAccount.setBankAccountType(BankAccount.BankAccountTypeEnum.RUSSIANBANKACCOUNT);
        russianLegalEntity.getAdditionalInfo().setBankAccount(russianBankAccount);
        russianLegalEntity.getAdditionalInfo()
                .setFinancialPosition(Collections.singletonList(new AnnualTaxReturnWithMark()
                        .financialPositionType(FinancialPosition.FinancialPositionTypeEnum.ANNUALTAXRETURNWITHMARK)));
        russianLegalEntity.getAdditionalInfo().setBusinessInfo(Collections.singletonList(new RetailTradeBusiness()
                .businessInfoType(BusinessInfo.BusinessInfoTypeEnum.RETAILTRADEBUSINESS)));
        russianLegalEntity.getAdditionalInfo().setAccountantInfo(EnhancedRandom.random(WithChiefAccountant.class)
                .accountantInfoType(AccountantInfo.AccountantInfoTypeEnum.WITHCHIEFACCOUNTANT));

        LegalOwnerInfo legalOwnerInfo = EnhancedRandom.random(LegalOwnerInfo.class);
        legalOwnerInfo.setIdentityDocument(EnhancedRandom.random(RussianDomesticPassport.class));
        russianLegalEntity.setLegalOwnerInfo(legalOwnerInfo);

        BeneficialOwner beneficialOwner = EnhancedRandom.random(BeneficialOwner.class);
        beneficialOwner.setResidencyInfo(EnhancedRandom.random(LegalResidencyInfo.class)
                .residencyInfoType(ResidencyInfo.ResidencyInfoTypeEnum.LEGALRESIDENCYINFO));
        beneficialOwner.setIdentityDocument(EnhancedRandom.random(RussianDomesticPassport.class)
                .identityDocumentType(IdentityDocument.IdentityDocumentTypeEnum.RUSSIANDOMESTICPASSPORT));
        beneficialOwner.setRussianPrivateEntity(EnhancedRandom.random(RussianPrivateEntity.class));
        russianLegalEntity.setBeneficialOwner(Collections.singletonList(beneficialOwner));

        FoundersInfo foundersInfo = new FoundersInfo();
        foundersInfo.setFounders(Collections.singletonList(EnhancedRandom.random(RussianLegalEntityFounder.class)
                .founderType(Founder.FounderTypeEnum.RUSSIANLEGALENTITYFOUNDER)));
        foundersInfo.setHeads(Collections.singletonList(EnhancedRandom.random(FounderHead.class)));
        foundersInfo.setLegalOwner(EnhancedRandom.random(FounderHead.class));
        russianLegalEntity.setFoundersInfo(foundersInfo);

        russianLegalEntity.setPropertyInfoDocumentType(EnhancedRandom.random(OtherPropertyInfoDocumentType.class)
                .documentType(PropertyInfoDocumentType.DocumentTypeEnum.OTHERPROPERTYINFODOCUMENTTYPE));

        legalEntityContractor.setLegalEntity(russianLegalEntity);

        questionaryParams.getData().setContractor(legalEntityContractor);
        questionaryParams.getData().setBankAccount(russianBankAccount);

        return questionaryParams;
    }

    public QuestionaryParams createInternationalLegalEntityQuestionarySwag() {
        QuestionaryParams questionaryParams = EnhancedRandom.random(QuestionaryParams.class);
        questionaryParams.setVersion("0");
        questionaryParams.getData().setShopInfo(
                EnhancedRandom.random(ShopInfo.class)
                        .location(EnhancedRandom.random(ShopLocationUrl.class)
                                .locationType(ShopLocation.LocationTypeEnum.SHOPLOCATIONURL)));

        LegalEntityContractor legalEntityContractor = new LegalEntityContractor();
        legalEntityContractor.setContractorType(Contractor.ContractorTypeEnum.LEGALENTITYCONTRACTOR);
        InternationalLegalEntity internationalLegalEntity = new InternationalLegalEntity()
                .tradingName("TrName")
                .registeredNumber("RegName")
                .registeredAddress("RedAddr")
                .actualAddress("ActAddr")
                .legalName("LgName");
        internationalLegalEntity.setLegalEntityType(INTERNATIONALLEGALENTITY);
        legalEntityContractor.setLegalEntity(internationalLegalEntity);

        questionaryParams.getData().setContractor(legalEntityContractor);
        var internationalBankAccount = EnhancedRandom.random(InternationalBankAccount.class);
        internationalBankAccount.setBankAccountType(BankAccount.BankAccountTypeEnum.INTERNATIONALBANKACCOUNT);
        questionaryParams.getData().setBankAccount(internationalBankAccount);

        return questionaryParams;
    }

    private dev.vality.questionary.InternationalBankAccount createTestIntBankAccount() {
        return new dev.vality.questionary.InternationalBankAccount()
                .setNumber("101")
                .setIban("ibbb")
                .setAccountHolder("holder-1")
                .setBank(new dev.vality.questionary.InternationalBankDetails()
                        .setName("test")
                        .setAddress("addr")
                        .setAbaRtn("abba")
                        .setBic("001122")
                        .setCountry(Residence.RUS)
                );
    }

    @SneakyThrows
    public <T extends TBase> T fillTBaseObject(T thriftBase, Class<T> type) {
        return mockTBaseProcessor.process(thriftBase, new TBaseHandler<>(type));
    }
}
