package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BackwardIteratorTest {
    @Test
    @DisplayName("hasNext test-1")
    void hasNext1() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1,2,3));
        assertThat(backwardIterator.hasNext()).isEqualTo(true);
    }

    @Test
    @DisplayName("hasNext test-2")
    void hasNext2() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1,2,3));
        backwardIterator.next();
        assertThat(backwardIterator.hasNext()).isEqualTo(true);
    }

    @Test
    @DisplayName("hasNext test-3")
    void hasNext3() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1,2,3));
        backwardIterator.next();
        backwardIterator.next();
        backwardIterator.next();
        assertThat(backwardIterator.hasNext()).isEqualTo(false);
    }

    @Test
    @DisplayName("next test-3")
    void next1() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1,2,3));
        assertThat(backwardIterator.next()).isEqualTo(3);
    }

    @Test
    @DisplayName("next test-2")
    void next2() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1,2,3));
        backwardIterator.next();
        assertThat(backwardIterator.next()).isEqualTo(2);
    }

    @Test
    @DisplayName("next test-1")
    void next3() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1,2,3));
        backwardIterator.next();
        backwardIterator.next();
        assertThat(backwardIterator.next()).isEqualTo(1);
    }

    @Test
    @DisplayName("next test exception")
    void nextException() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(List.of(1,2,3));
        backwardIterator.next();
        backwardIterator.next();
        backwardIterator.next();
        assertThrows(NoSuchElementException.class, backwardIterator::next);
    }
}
