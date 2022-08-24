package ru.netology.type;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProgressiveTaxType extends TaxType {
    //Прогрессивный налог - до 100 тысяч = 10%, больше 100 тысяч = 15%
    protected BigDecimal taxBracket = new BigDecimal("99999.9999999999");

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        if (amount.compareTo(taxBracket) <= 0) {
            rate = new BigDecimal("10.00");
            multiplied = amount.multiply(rate);
        } else {
            rate = new BigDecimal("15.00");
            multiplied = amount.multiply(rate);
        }
        return multiplied.divide(hundred, RoundingMode.HALF_EVEN);
    }
}