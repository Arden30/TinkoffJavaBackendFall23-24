package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String string = "11011110101010101";
        boolean contains = Task7.thirdZero(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String string = "1101";
        boolean contains = Task7.startEqualsEnd(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String string = "1100";
        boolean contains = Task7.startEqualsEnd(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        String string = "01011110";
        boolean contains = Task7.startEqualsEnd(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 5")
    void test5() {
        String string = "010";
        boolean contains = Task7.betweenOneThree(string);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 6")
    void test6() {
        String string = "0100";
        boolean contains = Task7.betweenOneThree(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 7")
    void test7() {
        String string = "01a";
        boolean contains = Task7.betweenOneThree(string);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 8")
    void test8() {
        String string = "01";
        boolean contains = Task7.betweenOneThree(string);

        assertThat(contains).isTrue();
    }
}
