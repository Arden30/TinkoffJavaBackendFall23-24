package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String license = "А123ВЕ777";

        boolean contains = Task5.validateLicensePlateNumber(license);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String license = "О777ОО177";

        boolean contains = Task5.validateLicensePlateNumber(license);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String license = "123АВЕ777";

        boolean contains = Task5.validateLicensePlateNumber(license);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        String license = "А123ВГ77";

        boolean contains = Task5.validateLicensePlateNumber(license);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 5")
    void test5() {
        String license = "А123ВЕ7777";

        boolean contains = Task5.validateLicensePlateNumber(license);

        assertThat(contains).isFalse();
    }
}
