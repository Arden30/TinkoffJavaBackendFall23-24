package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Test 1 (default)")
    void test1() {
        int source = 2;
        var res = Task4.convertToRoman(source);
        assertThat(res).isEqualTo("II");
    }

    @Test
    @DisplayName("Test 2 (default)")
    void test2() {
        int source = 12;
        var res = Task4.convertToRoman(source);
        assertThat(res).isEqualTo("XII");
    }

    @Test
    @DisplayName("Test 3 (default)")
    void test3() {
        int source = 16;
        var res = Task4.convertToRoman(source);
        assertThat(res).isEqualTo("XVI");
    }

    @Test
    @DisplayName("Test 4 (default)")
    void test4() {
        int source = 4;
        var res = Task4.convertToRoman(source);
        assertThat(res).isEqualTo("IV");
    }

    @Test
    @DisplayName("Test 5 (default)")
    void test5() {
        int source = 131;
        var res = Task4.convertToRoman(source);
        assertThat(res).isEqualTo("CXXXI");
    }

    @Test
    @DisplayName("Test 6 (negative number)")
    void test6() {
        int source = -4;
        var res = Task4.convertToRoman(source);
        assertThat(res).isEqualTo("Number must be positive");
    }

    @Test
    @DisplayName("Test 7 (large number)")
    void test7() {
        int source = 4231;
        var res = Task4.convertToRoman(source);
        assertThat(res).isEqualTo("Numbers larger than 3999 can't be written with classical roman numbers");
    }

}
