package ru.netology;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.type.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BillTests {

    Bill sut;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.out.println("Bill test started");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void started() {
        System.out.println("Bill tests started");
    }

    @AfterEach
    public void finished() {
        System.setOut(standardOut);
        System.out.println("Bill test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Bill tests completed");
    }

    @ParameterizedTest
    @MethodSource("sourceForZeroAmount")
    public void testPayTaxes_ZeroAmount(TaxType taxType) {
        // given:
        String expected = "Налоговая база отсутствует.";
        sut = new Bill(new BigDecimal("0"), taxType, new TaxService());
        // when:
        sut.payTaxes();
        // then:
        assertThat(expected, is(outputStreamCaptor.toString().trim()));
    }

    @ParameterizedTest
    @MethodSource("sourceForPositiveAmount")
    public void testPayTaxes_PositiveAmount(BigDecimal amount, TaxType taxType, String expected) {
        // given:
        sut = new Bill(amount, taxType, new TaxService());
        // when:
        sut.payTaxes();
        // then:
        assertThat(expected, is(outputStreamCaptor.toString().trim()));
    }

    private static Stream<Arguments> sourceForZeroAmount() {
        return Stream.of(Arguments.of(new IncomeTaxType()),
                Arguments.of(new ProgressiveTaxType()),
                Arguments.of(new VATaxType()));
    }

    private static Stream<Arguments> sourceForPositiveAmount() {
        return Stream.of(
                Arguments.of(new BigDecimal("100.00"),
                        new IncomeTaxType(),
                        "Уплачен налог в размере 13.00"),
                Arguments.of(new BigDecimal("100.00"),
                        new ProgressiveTaxType(),
                        "Уплачен налог в размере 10.00"),
                Arguments.of(new BigDecimal("100.00"),
                        new VATaxType(),
                        "Уплачен налог в размере 18.00"),
                Arguments.of(new BigDecimal("100000.00"),
                        new IncomeTaxType(),
                        "Уплачен налог в размере 13000.00"),
                Arguments.of(new BigDecimal("100000.00"),
                        new ProgressiveTaxType(),
                        "Уплачен налог в размере 15000.00"),
                Arguments.of(new BigDecimal("100000.00"),
                        new VATaxType(),
                        "Уплачен налог в размере 18000.00"));
    }
}