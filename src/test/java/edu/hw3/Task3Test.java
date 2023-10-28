package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Test 1 (strings)")
    void test1() {
        List<String> source = Arrays.asList("a", "bb", "a", "bb");
        var res = Task3.freqDict(source);
        assertThat(res).isEqualTo(Map.of("bb",2, "a",  2));
    }

    @Test
    @DisplayName("Test 2 (strings)")
    void test2() {
        List<String> source = Arrays.asList("this", "and", "that", "and");
        var res = Task3.freqDict(source);
        assertThat(res).isEqualTo(Map.of("that", 1, "and", 2, "this", 1));
    }

    @Test
    @DisplayName("Test 3 (integers)")
    void test3() {
        List<Integer> source = Arrays.asList(1, 1, 2, 2);
        var res = Task3.freqDict(source);
        assertThat(res).isEqualTo(Map.of(1, 2, 2, 2));
    }

    @Test
    @DisplayName("Test 4 (lists)")
    void test4() {
        List<String> list1 = Arrays.asList("Hello", ",", "Java", "!");
        List<String> list2 = Arrays.asList("Hello", ",", "Java", "!");
        List<String> list3 = Arrays.asList("Hello", ",", "Java", "???");
        List<List<String>> source = new ArrayList<>();
        source.add(list1);
        source.add(list2);
        source.add(list3);
        var res = Task3.freqDict(source);
        assertThat(res).isEqualTo(Map.of(Arrays.asList("Hello", ",", "Java", "!"), 2, Arrays.asList("Hello", ",", "Java", "???"), 1));
    }
}
