package ru.netology.type;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TaxTypeTests {

    TaxType sut;

    @BeforeEach
    public void init() {
        System.out.println("TaxType test started");
        sut = new TaxType();
    }

    @BeforeAll
    public static void started() {
        System.out.println("TaxType tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("TaxType test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("TaxType tests completed");
    }

    @Test
    public void testCalculateTaxFor() {
        // given:
        BigDecimal expected = new BigDecimal("0.00");
        BigDecimal amount = new BigDecimal("100.00");
        // when:
        BigDecimal result = sut.calculateTaxFor(amount);
        // then:
        assertThat(result, is(expected));
    }
}