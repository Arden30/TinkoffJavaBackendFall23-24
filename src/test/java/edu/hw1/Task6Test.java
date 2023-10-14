package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Капрекар-1")
    void kaprekar1() {
        //given
        int n = 6621;

        //when
        int result = Task6.k(n);

        //then
        assertThat(result)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("Капрекар-2")
    void kaprekar2() {
        //given
        int n = 6554;

        //when
        int result = Task6.k(n);

        //then
        assertThat(result)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Капрекар-3")
    void kaprekar3() {
        //given
        int n = 1234;

        //when
        int result = Task6.k(n);

        //then
        assertThat(result)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Капрекар-4")
    void kaprekar4() {
        //given
        int n = 1001;

        //when
        int result = Task6.k(n);

        //then
        assertThat(result)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Одинаковые цифры")
    void equalDigits() {
        //given
        int n = 1111;

        //when
        int result = Task6.k(n);

        //then
        assertThat(result)
            .isEqualTo(-1);
    }
}
