package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Валидные данные")
    void simpleCounting() {
        //given
        int number = 4666;

        //when
        int result = Task2.countDigits(number);

        //then
        assertThat(result)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Отрицательное число")
    void negativeNumber() {
        //given
        int number = -3;

        //when
        int result = Task2.countDigits(number);

        //then
        assertThat(result)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Ноль")
    void zeroDigit() {
        //given
        int number = 0;

        //when
        int result = Task2.countDigits(number);

        //then
        assertThat(result)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Большое число")
    void bigNumber() {
        //given
        int number = 466623432;

        //when
        int result = Task2.countDigits(number);

        //then
        assertThat(result)
            .isEqualTo(9);
    }

    @Test
    @DisplayName("Ведущие нули")
    void extraZeroes() {
        //given
        int number = 000012;

        //when
        int result = Task2.countDigits(number);

        //then
        assertThat(result)
            .isEqualTo(2);
    }

    @Test
    @DisplayName("Одна цифра")
    void singleDigit() {
        //given
        int number = 1;

        //when
        int result = Task2.countDigits(number);

        //then
        assertThat(result)
            .isEqualTo(1);
    }
}
