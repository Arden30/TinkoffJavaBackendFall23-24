package edu.hw8;

import edu.hw8.task2.Fibonacci;
import edu.hw8.task2.FixedThreadPool;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Disabled
public class Task2Test {
    private final int n = 30;
    private volatile long[] fibs;
    private FixedThreadPool fixedThreadPool;
    private final long[] fibAll = {0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L, 75025L, 121393L, 196418L, 317811L, 514229L};
    @Test
    @DisplayName("Test 1 (multithreading)")
    void test1() {
        try {
            fixedThreadPool = FixedThreadPool.create(5);
            fixedThreadPool.start();
            long start = System.nanoTime();
            fixedThreadPool.start();
            fibs = new long[n];
            for (int i = 0; i < n; i++) {
                int finalI = i;
                fixedThreadPool.execute(() -> fibs[finalI] = Fibonacci.countFib(finalI));
            }
            System.out.println("Multithreading: " + (System.nanoTime() - start) / 1_000_000_000.0 + " sec");
            assertThat(fibs).isEqualTo(fibAll);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    @DisplayName("Test 2 (single thread)")
    void test2() {
        long start = System.nanoTime();
        fibs = new long[n];
        for (int i = 0; i < n; i++) {
            fibs[i] = Fibonacci.countFib(i);
        }
        System.out.println("Single thread: " + (System.nanoTime() - start) / 1_000_000_000.0 + " sec");
        assertThat(fibs).isEqualTo(fibAll);
    }
}
