package ru.netology.type;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TaxServiceTests {

    TaxService sut;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.out.println("TaxService test started");
        sut = new TaxService();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void started() {
        System.out.println("TaxService tests started");
    }

    @AfterEach
    public void finished() {
        System.setOut(standardOut);
        System.out.println("TaxService test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("TaxService tests completed");
    }

    @Test
    public void testPayOut() {
        // given:
        String expected = "Уплачен налог в размере 100.00";
        BigDecimal amount = new BigDecimal("100.00");
        // when:
        sut.payOut(amount);
        // then:
        assertThat(outputStreamCaptor.toString().trim(), containsString(expected));
    }
}