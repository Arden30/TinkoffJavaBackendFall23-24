package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String string = "achfdbaabgabcaabg";
        String subsequence = "abc";
        boolean contains = Task6.subsequence(string, subsequence);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String string = "achfdbaabgabaabgc";
        String subsequence = "abc";
        boolean contains = Task6.subsequence(string, subsequence);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String string = "ab";
        String subsequence = "abc";
        boolean contains = Task6.subsequence(string, subsequence);

        assertThat(contains).isFalse();
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        String string = "abc";
        String subsequence = "abc";
        boolean contains = Task6.subsequence(string, subsequence);

        assertThat(contains).isTrue();
    }

    @Test
    @DisplayName("Test 5")
    void test5() {
        String string = "akjbhj";
        String subsequence = "abc";
        boolean contains = Task6.subsequence(string, subsequence);

        assertThat(contains).isFalse();
    }
}
