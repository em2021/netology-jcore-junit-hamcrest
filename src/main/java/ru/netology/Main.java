package ru.netology;

import ru.netology.type.IncomeTaxType;
import ru.netology.type.ProgressiveTaxType;
import ru.netology.type.TaxService;
import ru.netology.type.VATaxType;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        IncomeTaxType incomeTaxType = new IncomeTaxType();
        VATaxType vaTaxType = new VATaxType();
        ProgressiveTaxType progressiveTaxType = new ProgressiveTaxType();
        Bill[] payments = new Bill[]{
                new Bill(new BigDecimal("1000.00"), incomeTaxType, taxService),
                new Bill(new BigDecimal("10000.00"), vaTaxType, taxService),
                new Bill(new BigDecimal("99999.99"), progressiveTaxType, taxService),
                new Bill(new BigDecimal("100000.00"), progressiveTaxType, taxService),
                new Bill(new BigDecimal("0.00"), progressiveTaxType, taxService)
        };
        for (int i = 0; i < payments.length; ++i) {
            Bill bill = payments[i];
            bill.payTaxes();
        }
    }
}