package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Test 1 (default)")
    void test1() {
        String source = "()()()";
        var res = Task2.clusterize(source);
        assertThat(res).isEqualTo(Arrays.asList("()", "()", "()"));
    }

    @Test
    @DisplayName("Test 2 (default)")
    void test2() {
        String source = "((()))";
        var res = Task2.clusterize(source);
        assertThat(res).isEqualTo(Arrays.asList("((()))"));
    }

    @Test
    @DisplayName("Test 3 (default)")
    void test3() {
        String source = "((()))(())()()(()())";
        var res = Task2.clusterize(source);
        assertThat(res).isEqualTo(Arrays.asList("((()))", "(())", "()", "()", "(()())"));
    }

    @Test
    @DisplayName("Test 4 (default)")
    void test4() {
        String source = "((())())(()(()()))";
        var res = Task2.clusterize(source);
        assertThat(res).isEqualTo(Arrays.asList("((())())", "(()(()()))"));
    }

    @Test
    @DisplayName("Test 5 (with other chars)")
    void test5() {
        String source = "(7 * (2 - (1 + 1) + 3) - (2 * 2) - 4) * (1 - (2 + 3) - 7 * ((1 - 1) * (1 + 1) - 3))";
        var res = Task2.clusterize(source);
        assertThat(res).isEqualTo(Arrays.asList("((())())", "(()(()()))"));
    }

    @Test
    @DisplayName("Test 6 (can't be clusterized)")
    void test6() {
        String source = "((())))";
        var res = Task2.clusterize(source);
        assertThat(res).isEqualTo(null);
    }

    @Test
    @DisplayName("Test 6 (without brackets)")
    void test7() {
        String source = "abc";
        var res = Task2.clusterize(source);
        assertThat(res).isEqualTo(Arrays.asList());
    }
}
