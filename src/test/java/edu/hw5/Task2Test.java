package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test 1 (all fridays)")
    void test1() {
        int year = 1925;
        List<LocalDate> res = List.of(LocalDate.of(1925, 2, 13), LocalDate.of(1925, 3, 13), LocalDate.of(1925, 11, 13));
        assertThat(Task2.thirteenthFridays(year)).isEqualTo(res);
    }

    @Test
    @DisplayName("Test 2 (all fridays)")
    void test2() {
        int year = 2024;
        List<LocalDate> res = List.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13));
        assertThat(Task2.thirteenthFridays(year)).isEqualTo(res);
    }

    @Test
    @DisplayName("Test 3 (next friday)")
    void test3() {
        LocalDate date = LocalDate.of(1925, 2, 15);
        LocalDate friday = LocalDate.of(1925, 3, 13);
        assertThat(Task2.nextThirteenthFriday(date)).isEqualTo(friday);
    }

    @Test
    @DisplayName("Test 4 (next friday)")
    void test4() {
        LocalDate date = LocalDate.of(2024, 9, 13);
        LocalDate friday = LocalDate.of(2024, 12, 13);
        assertThat(Task2.nextThirteenthFriday(date)).isEqualTo(friday);
    }
}
