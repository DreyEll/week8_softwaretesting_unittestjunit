package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Test kelas SimpleValidator")
class SimpleValidatorTest {

    private SimpleValidator validator;

    @BeforeEach
    void setUp() {
        validator = new SimpleValidator();
    }

    @Test
    @DisplayName("validateAge mengembalikan Belum Dewasa untuk umur di bawah 18")
    void testValidateAgeUnder18() {
        assertEquals("Belum Dewasa", validator.validateAge(17));
    }

    @Test
    @DisplayName("validateAge mengembalikan Dewasa untuk umur 18")
    void testValidateAgeAdult() {
        assertEquals("Dewasa", validator.validateAge(18));
    }

    @Test
    @DisplayName("validateAge melempar exception untuk umur negatif")
    void testValidateAgeNegativeThrows() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateAge(-1)
        );
        assertEquals("Umur tidak boleh negatif", exception.getMessage());
    }

    @Test
    @DisplayName("calculateDiscount tanpa member menghasilkan diskon 0")
    void testCalculateDiscountNoMember() {
        assertEquals(0.0, validator.calculateDiscount(30000, false));
    }

    @Test
    @DisplayName("calculateDiscount member dengan belanja besar memberikan diskon 10%")
    void testCalculateDiscountMember() {
        assertEquals(10000.0, validator.calculateDiscount(100000, true));
    }

    @Test
    @DisplayName("calculateDiscount melempar exception jika total belanja negatif")
    void testCalculateDiscountNegativeThrows() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.calculateDiscount(-1, false)
        );
        assertEquals("Total belanja tidak boleh negatif", exception.getMessage());
    }

    @Test
    @DisplayName("classifyGrade mengembalikan A untuk nilai 90")
    void testClassifyGradeA() {
        assertEquals("A", validator.classifyGrade(90));
    }

    @Test
    @DisplayName("classifyGrade melempar exception jika nilai lebih dari 100")
    void testClassifyGradeOutOfRangeThrows() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.classifyGrade(101)
        );
        assertEquals("Nilai harus berada di rentang 0-100", exception.getMessage());
    }

    @ParameterizedTest(name = "nilai {0} => {1}")
    @DisplayName("Boundary Value Analysis pada nilai grade")
    @CsvSource({
            "39, E",
            "40, D",
            "60, C",
            "90, A"
    })
    void testClassifyGradeBoundaryValueAnalysis(int score, String expected) {
        assertEquals(expected, validator.classifyGrade(score));
    }
}
