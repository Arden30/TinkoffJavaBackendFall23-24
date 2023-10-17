package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Потомок3 - палиндром")
    void descendantPalindrome3() {
        //given
        int num = 11211230;

        //when
        boolean result = Task5.isPalindromeDescendant(num);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Потомок2 - палиндром")
    void descendantPalindrome2() {
        //given
        int num = 13001120;

        //when
        boolean result = Task5.isPalindromeDescendant(num);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Четный палиндром")
    void palindromeEven() {
        //given
        int num = 11;

        //when
        boolean result = Task5.isPalindromeDescendant(num);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Нечетный палиндром")
    void palindromeOdd() {
        //given
        int num = 121;

        //when
        boolean result = Task5.isPalindromeDescendant(num);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Одна цифра")
    void singleDigit() {
        //given
        int num = 1;

        //when
        boolean result = Task5.isPalindromeDescendant(num);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Не палиндром")
    void notPalindrome() {
        //given
        int num = 1564;

        //when
        boolean result = Task5.isPalindromeDescendant(num);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

}
