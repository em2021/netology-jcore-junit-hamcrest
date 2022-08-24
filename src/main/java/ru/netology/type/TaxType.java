package ru.netology.type;

import java.math.BigDecimal;

public class TaxType {
    protected BigDecimal rate;
    protected BigDecimal multiplied;
    protected BigDecimal hundred = new BigDecimal("100.00");

    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return new BigDecimal("0.00");
    }
}