package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String password = "J@v#";

        boolean contains = Task4.validatePassword(password);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String password = "Java";

        boolean contains = Task4.validatePassword(password);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String password = "  !";

        boolean contains = Task4.validatePassword(password);

        assertThat(contains).isTrue();
    }
}
