package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Обычный вложенный массив")
    void nested() {
        //given
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 6};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Невложенный массив из-за min")
    void notMinNested() {
        //given
        int[] arr1 = {9, 9, 8};
        int[] arr2 = {8, 10};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Невложенный массив из-за max")
    void notMaxNested() {
        //given
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 4};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Совпадают min/max")
    void equalMinMax() {
        //given
        int[] arr1 = {9, 9, 9};
        int[] arr2 = {8, 9};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Одинаковые массивы")
    void equal() {
        //given
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 2, 1};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Массивы с 1 элементом")
    void allSingleSize() {
        //given
        int[] arr1 = {1};
        int[] arr2 = {2};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Вложенный массив arr1 с 1 элементом")
    void nestedOneArrSingledSize() {
        //given
        int[] arr1 = {1};
        int[] arr2 = {0, 3, 5};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Невложенный массив arr1 с 1 элементом")
    void notNestedOneArrSingledSize() {
        //given
        int[] arr1 = {0};
        int[] arr2 = {0, 3, 5};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Пустой массив")
    void emptyArray() {
        //given
        int[] arr1 = {};
        int[] arr2 = {0, 3, 5};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Пустые массив")
    void emptyArrays() {
        //given
        int[] arr1 = {};
        int[] arr2 = {};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Null array")
    void nullArray() {
        //given
        int[] arr1 = null;
        int[] arr2 = {1, 2, 100};

        //when
        boolean result = Task3.isNestable(arr1, arr2);

        //then
        assertThat(result)
            .isEqualTo(false);
    }
}
