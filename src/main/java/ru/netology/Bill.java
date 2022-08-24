package ru.netology;

import ru.netology.type.TaxService;
import ru.netology.type.TaxType;

import java.math.BigDecimal;

public class Bill {
    private BigDecimal amount;
    private TaxType taxType;
    private TaxService taxService;

    public Bill(BigDecimal amount, TaxType taxType, TaxService taxService) {
        this.amount = amount;
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public void payTaxes() {
        if (amount.compareTo(new BigDecimal("0.0000000001")) <= 0) {
            System.out.println("Налоговая база отсутствует.");
        } else {
            BigDecimal taxAmount = taxType.calculateTaxFor(amount);
            taxService.payOut(taxAmount);
        }
    }
}