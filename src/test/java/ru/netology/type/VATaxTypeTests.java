package ru.netology.type;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.typeCompatibleWith;

public class VATaxTypeTests {

    VATaxType sut;

    @BeforeEach
    public void init() {
        System.out.println("VATaxType test started");
        sut = new VATaxType();
    }

    @BeforeAll
    public static void started() {
        System.out.println("VATaxType tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("VATaxType test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("VATaxType tests completed");
    }

    @Test
    public void testCalculateTaxFor_PositiveAmount() {
        // given:
        BigDecimal expected = new BigDecimal("18.0000");
        BigDecimal amount = new BigDecimal("100.00");
        // when:
        BigDecimal result = sut.calculateTaxFor(amount);
        // then:
        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateTaxFor_ZeroAmount() {
        // given:
        BigDecimal expected = new BigDecimal("0.00");
        BigDecimal amount = new BigDecimal("0");
        // when:
        BigDecimal result = sut.calculateTaxFor(amount);
        // then:
        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateTaxFor_AmountBelowZero() {
        // given:
        BigDecimal expected = new BigDecimal("-0.18000");
        // when:
        BigDecimal result = sut.calculateTaxFor(new BigDecimal("-1.000"));
        // then:
        assertThat(result, is(expected));
    }

    @Test
    public void testTaxTypeCompatibility() {
        assertThat(sut.getClass(), typeCompatibleWith(TaxType.class));
    }
}