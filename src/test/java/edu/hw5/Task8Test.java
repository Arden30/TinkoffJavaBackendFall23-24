package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String string = "11110";
        boolean contains = Task8.oddLength(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String string = "1111";
        boolean contains = Task8.oddLength(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String string = "";
        boolean contains = Task8.oddLength(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        String string = "011";
        boolean contains = Task8.oddZeroOrEvenOne(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 5")
    void test5() {
        String string = "0111";
        boolean contains = Task8.oddZeroOrEvenOne(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 6")
    void test6() {
        String string = "1111";
        boolean contains = Task8.oddZeroOrEvenOne(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 7")
    void test7() {
        String string = "111";
        boolean contains = Task8.oddZeroOrEvenOne(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 8")
    void test8() {
        String string = "111";
        boolean contains = Task8.oddZeroOrEvenOne(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 9")
    void test9() {
        String string = "000101000010";
        boolean contains = Task8.zeroesMultipleOfThree(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 10")
    void test10() {
        String string = "0001010010";
        boolean contains = Task8.zeroesMultipleOfThree(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 11")
    void test11() {
        String string = "11";
        boolean contains = Task8.allExcept11Or111(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 12")
    void test12() {
        String string = "111";
        boolean contains = Task8.allExcept11Or111(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 13")
    void test13() {
        String string = "1111";
        boolean contains = Task8.allExcept11Or111(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 14")
    void test14() {
        String string = "1";
        boolean contains = Task8.allExcept11Or111(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 15")
    void test15() {
        String string = "101";
        boolean contains = Task8.everyThirdIsOne(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 16")
    void test16() {
        String string = "1010";
        boolean contains = Task8.everyThirdIsOne(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 17")
    void test17() {
        String string = "0010";
        boolean contains = Task8.everyThirdIsOne(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 18")
    void test18() {
        String string = "1";
        boolean contains = Task8.everyThirdIsOne(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 18")
    void test19() {
        String string = "0";
        boolean contains = Task8.everyThirdIsOne(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 20")
    void test20() {
        String string = "";
        boolean contains = Task8.everyThirdIsOne(string);

        assertThat(contains).isTrue();
    }
}
