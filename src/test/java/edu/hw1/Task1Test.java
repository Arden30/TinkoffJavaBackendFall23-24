package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Обычные валидные данныe")
    void simpleCalculation() {
        //given
        String time = "13:56";

        //when
        int result = Task1.minutesToSeconds(time);

        //then
        assertThat(result)
            .isEqualTo(13 * 60 + 56);
    }

    @Test
    @DisplayName("Дополнительные нули")
    void extraZeroes() {
        //given
        String time = "00000013:00056";

        //when
        int result = Task1.minutesToSeconds(time);

        //then
        assertThat(result)
            .isEqualTo(13 * 60 + 56);
    }

    @Test
    @DisplayName("Нулевое время")
    void zeroTime() {
        //given
        String time = "000:0000";

        //when
        int result = Task1.minutesToSeconds(time);

        //then
        assertThat(result)
            .isEqualTo(0);
    }

    @Test
    @DisplayName("Огромное значение для минут")
    void bigAmountOfMinutes() {
        //given
        String time = "999999:59";

        //when
        int result = Task1.minutesToSeconds(time);

        //then
        assertThat(result)
            .isEqualTo(999999 * 60 + 59);
    }

    @Test
    @DisplayName("Отрицательное время не валидно")
    void negativeTime() {
        //given
        String time = "-1:-59";

        //when
        int result = Task1.minutesToSeconds(time);

        //then
        assertThat(result)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("60 секунд")
    void sixtySeconds() {
        //given
        String time = "13:60";

        //when
        int result = Task1.minutesToSeconds(time);

        //then
        assertThat(result)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("60 секунд")
    void bigAmountOfSeconds() {
        //given
        String time = "13:77";

        //when
        int result = Task1.minutesToSeconds(time);

        //then
        assertThat(result)
            .isEqualTo(-1);
    }
}
