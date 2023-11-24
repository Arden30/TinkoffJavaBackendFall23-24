package edu.hw7;

import edu.hw7.task2.ParallelFactorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        int n = 5;
        int expected = 120;

        int res = ParallelFactorial.factorial(n);

        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        int n = 0;
        int expected = 1;

        int res = ParallelFactorial.factorial(n);

        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        int n = -10;

        assertThrows(IllegalArgumentException.class, () -> ParallelFactorial.factorial(n));
    }
}
