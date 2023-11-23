package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    @DisplayName("Test 1 (appropriate input)")
    void test1() {
        String[] times = {"2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"};
        String avg = "3ч 40м";
        assertThat(Task1.avgTime(times)).isEqualTo(avg);
    }

    @Test
    @DisplayName("Test 2 (wrong input)")
    void test2() {
        String[] times = {"2022-03aa-12, 20:20 - 2022-03-12, 2d3:50", "2022s-04-01, 21:30 - 202d2-04-02, 01:20"};
        assertThrows(IllegalArgumentException.class, () -> Task1.avgTime(times));
    }
}
