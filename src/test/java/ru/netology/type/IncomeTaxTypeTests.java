package ru.netology.type;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.typeCompatibleWith;

public class IncomeTaxTypeTests {

    IncomeTaxType sut;

    @BeforeEach
    public void init() {
        System.out.println("IncomeTaxType test started");
        sut = new IncomeTaxType();
    }

    @BeforeAll
    public static void started() {
        System.out.println("IncomeTaxType tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("IncomeTaxType test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("IncomeTaxType tests completed");
    }

    @Test
    public void testCalculateTaxFor_PositiveAmount() {
        // given:
        BigDecimal expected = new BigDecimal("13.000");
        // when:
        BigDecimal result = sut.calculateTaxFor(new BigDecimal("100.0"));
        // then:
        assertThat(result, is(expected));
    }

    @Test
    public void testCalculateTaxFor_ZeroAmount() {
        // given:
        BigDecimal expected = new BigDecimal("0.00");
        // when:
        BigDecimal result = sut.calculateTaxFor(new BigDecimal("0"));
        // then:
        assertThat(result, is(expected));
    }

    @Test
    public void testTaxTypeCompatibility() {
        assertThat(sut.getClass(), typeCompatibleWith(TaxType.class));
    }
}