package edu.hw7.task2;

import java.util.stream.LongStream;

public final class ParallelFactorial {
    private ParallelFactorial() {

    }

    public static long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        return LongStream.rangeClosed(1, n).parallel().reduce((x, y) -> x * y).orElse(1);
    }
}
