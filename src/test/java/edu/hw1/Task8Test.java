package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("Не захватить")
    void canNotReach() {
        //given
        int[][] matrix =
            {{0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}};

        //when
        boolean result = Task8.knightBoardCapture(matrix);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Захват-1")
    void canReach1() {
        //given
        int[][] matrix =
            {{1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}};

        //when
        boolean result = Task8.knightBoardCapture(matrix);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Захват-2")
    void canReach2() {
        //given
        int[][] matrix =
            {{0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};

        //when
        boolean result = Task8.knightBoardCapture(matrix);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Пустое поле")
    void emptyBoard() {
        //given
        int[][] matrix =
            {{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};

        //when
        boolean result = Task8.knightBoardCapture(matrix);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Граничные кони")
    void edgeKnight() {
        //given
        int[][] matrix =
            {{1, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 1}};

        //when
        boolean result = Task8.knightBoardCapture(matrix);

        //then
        assertThat(result)
            .isEqualTo(true);
    }
}
