package ru.netology.type;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VATaxType extends TaxType {
    //НДС 18%
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        rate = new BigDecimal("18.00");
        multiplied = amount.multiply(rate);
        return multiplied.divide(hundred, RoundingMode.HALF_EVEN);
    }
}