package dev.vality.dark.api.converter.questionary;

import dev.vality.dark.api.converter.SwagConverter;
import dev.vality.dark.api.converter.SwagConverterContext;
import dev.vality.dark.api.converter.ThriftConverter;
import dev.vality.dark.api.converter.ThriftConverterContext;
import dev.vality.questionary.FinancialPosition;
import dev.vality.swag.questionary.model.*;
import dev.vality.swag.questionary.model.FinancialPosition.FinancialPositionTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class FinancialPositionConverter implements
        ThriftConverter<FinancialPosition, dev.vality.swag.questionary.model.FinancialPosition>,
        SwagConverter<dev.vality.swag.questionary.model.FinancialPosition, FinancialPosition> {

    @Override
    public dev.vality.swag.questionary.model.FinancialPosition toSwag(FinancialPosition value,
                                                                        SwagConverterContext ctx) {
        if (value.isSetAnnualFinancialStatements()) {
            return new AnnualFinancialStatements()
                    .financialPositionType(FinancialPositionTypeEnum.ANNUALFINANCIALSTATEMENTS);
        } else if (value.isSetAnnualTaxReturnWithMark()) {
            return new AnnualTaxReturnWithMark()
                    .financialPositionType(FinancialPositionTypeEnum.ANNUALTAXRETURNWITHMARK);
        } else if (value.isSetAnnualTaxReturnWithoutMark()) {
            return new AnnualTaxReturnWithoutMark()
                    .financialPositionType(FinancialPositionTypeEnum.ANNUALTAXRETURNWITHOUTMARK);
        } else if (value.isSetAnnualTaxReturnWithoutMarkPaper()) {
            return new AnnualTaxReturnWithoutMarkPaper()
                    .financialPositionType(FinancialPositionTypeEnum.ANNUALTAXRETURNWITHOUTMARKPAPER);
        } else if (value.isSetLetterOfGuarantee()) {
            return new LetterOfGuarantee().financialPositionType(FinancialPositionTypeEnum.LETTEROFGUARANTEE);
        } else if (value.isSetQuarterlyTaxReturnWithMark()) {
            return new QuarterlyTaxReturnWithMark()
                    .financialPositionType(FinancialPositionTypeEnum.QUARTERLYTAXRETURNWITHMARK);
        } else if (value.isSetQuarterlyTaxReturnWithoutMark()) {
            return new QuarterlyTaxReturnWithoutMark()
                    .financialPositionType(FinancialPositionTypeEnum.QUARTERLYTAXRETURNWITHOUTMARK);
        } else if (value.isSetStatementOfDuty()) {
            return new StatementOfDuty().financialPositionType(FinancialPositionTypeEnum.STATEMENTOFDUTY);
        }

        throw new IllegalArgumentException("Unknown financialPosition type: " + value.getClass().getName());
    }

    @Override
    public FinancialPosition toThrift(dev.vality.swag.questionary.model.FinancialPosition value,
                                      ThriftConverterContext ctx) {
        FinancialPosition financialPosition = new FinancialPosition();
        switch (value.getFinancialPositionType()) {
            case ANNUALFINANCIALSTATEMENTS:
                financialPosition
                        .setAnnualFinancialStatements(new dev.vality.questionary.AnnualFinancialStatements());
                return financialPosition;
            case ANNUALTAXRETURNWITHMARK:
                financialPosition.setAnnualTaxReturnWithMark(new dev.vality.questionary.AnnualTaxReturnWithMark());
                return financialPosition;
            case ANNUALTAXRETURNWITHOUTMARK:
                financialPosition
                        .setAnnualTaxReturnWithoutMark(new dev.vality.questionary.AnnualTaxReturnWithoutMark());
                return financialPosition;
            case ANNUALTAXRETURNWITHOUTMARKPAPER:
                financialPosition.setAnnualTaxReturnWithoutMarkPaper(
                        new dev.vality.questionary.AnnualTaxReturnWithoutMarkPaper());
                return financialPosition;
            case LETTEROFGUARANTEE:
                financialPosition.setLetterOfGuarantee(new dev.vality.questionary.LetterOfGuarantee());
                return financialPosition;
            case QUARTERLYTAXRETURNWITHMARK:
                financialPosition
                        .setQuarterlyTaxReturnWithMark(new dev.vality.questionary.QuarterlyTaxReturnWithMark());
                return financialPosition;
            case QUARTERLYTAXRETURNWITHOUTMARK:
                financialPosition
                        .setQuarterlyTaxReturnWithoutMark(new dev.vality.questionary.QuarterlyTaxReturnWithoutMark());
                return financialPosition;
            case STATEMENTOFDUTY:
                financialPosition.setStatementOfDuty(new dev.vality.questionary.StatementOfDuty());
                return financialPosition;
            default:
                throw new IllegalArgumentException(
                        "Unknown financialPosition type: " + value.getFinancialPositionType());
        }
    }

}
