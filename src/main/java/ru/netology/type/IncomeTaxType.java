package ru.netology.type;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeTaxType extends TaxType {
    //Подоходный налог 13%
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        rate = new BigDecimal("13.00");
        multiplied = amount.multiply(rate);
        return multiplied.divide(hundred, RoundingMode.HALF_EVEN);
    }
}