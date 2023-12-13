package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static edu.hw7.task4.MonteCarlo.countPI;
import static edu.hw7.task4.MonteCarlo.multiCountPI;

public class Task4Test {
    private static final int THREADS = 6;

    @ParameterizedTest
    @ValueSource(longs = {
        10_000_000L,
        100_000_000L,
        1_000_000_000L
    })
    @DisplayName("Test 1 (single thread)")
    void test1(long circles) {
        if (circles == 10_000_000L) {
            System.out.println("Single thread version:\n");
        }

        long start = System.nanoTime();

        double pi = countPI(circles);

        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000_000.0;

        System.out.println("Execution time(" + circles + " circles)" + ": " + duration + " sec");
        System.out.printf("Inaccuracy: %.4f%%\n\n", 100 * Math.abs(1 - Math.PI / pi));
    }

    @ParameterizedTest
    @ValueSource(longs = {
        10_000_000L,
        100_000_000L,
        1_000_000_000L
    })
    @DisplayName("Test 2 (multithreading)")
    void test2(long circles) {
        if (circles == 10_000_000L) {
            System.out.println("Multithreading version:\n");
        }

        long start = System.nanoTime();

        double pi = multiCountPI(circles, THREADS);

        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000_000.0;

        System.out.println("Execution time (" + circles + " circles)" + ": " + duration + " sec");
        System.out.printf("Inaccuracy: %.4f%%\n\n", 100 * Math.abs(1 - Math.PI / pi));
    }
}
