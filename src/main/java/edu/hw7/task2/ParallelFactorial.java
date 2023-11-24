package edu.hw7.task2;

import java.util.stream.IntStream;

public final class ParallelFactorial {
    private ParallelFactorial() {

    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        return IntStream.rangeClosed(1, n).parallel().reduce((x, y) -> x * y).orElse(1);
    }
}
