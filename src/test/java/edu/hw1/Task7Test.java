package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("RotateRight-1")
    void rotateRight1() {
        //given
        int n = 8;
        int shift = 1;

        //when
        int result = Task7.rotateRight(n, shift);

        //then
        assertThat(result)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("RotateRight-2")
    void rotateRight2() {
        //given
        int n = 19;
        int shift = 3;

        //when
        int result = Task7.rotateRight(n, shift);

        //then
        assertThat(result)
            .isEqualTo(14);
    }

    @Test
    @DisplayName("RotateLeft-1")
    void rotateLeft1() {
        //given
        int n = 16;
        int shift = 1;

        //when
        int result = Task7.rotateLeft(n, shift);

        //then
        assertThat(result)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("RotateLeft-2")
    void rotateLeft2() {
        //given
        int n = 17;
        int shift = 2;

        //when
        int result = Task7.rotateLeft(n, shift);

        //then
        assertThat(result)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("RotateLeft for 1")
    void rotateLeftFor1() {
        //given
        int n = 1;
        int shift = 3;

        //when
        int result = Task7.rotateLeft(n, shift);

        //then
        assertThat(result)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("RotateRight for 1")
    void rotateRightFor1() {
        //given
        int n = 1;
        int shift = 3;

        //when
        int result = Task7.rotateRight(n, shift);

        //then
        assertThat(result)
            .isEqualTo(1);
    }
}
