package edu.hw3;

import edu.hw3.task7.NullComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NullComparatorTest {

    @Test
    @DisplayName("Test (default)")
    void test1() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<>());
        tree.put("1", "hi");
        tree.put("2", "hello");
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
