package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    @DisplayName("Rectangle and square -> rectangle")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200.0);
    }

    @Test
    @DisplayName("Square-1")
    void squareArea() {
        Square square = new Square(10);

        assertThat(square.area()).isEqualTo(100);
    }

    @Test
    @DisplayName("Square-2")
    void squareSetArea() {
        Square square = new Square(1);
        square = square.setSize(2);

        assertThat(square.area()).isEqualTo(4);
    }

    @Test
    @DisplayName("Rectangle -> square")
    void rectangleSquareArea() {
        Rectangle square = new Square(5);

        assertThat(square.area()).isEqualTo(25);
    }

    @Test
    @DisplayName("Square -> rectangle")
    void squareRectangleArea() {
        Rectangle square = new Square(3);
        square = square.setWidth(5);
        square = square.setHeight(10);

        assertThat(square.area()).isEqualTo(50);
    }
}
