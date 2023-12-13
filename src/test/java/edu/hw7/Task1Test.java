package edu.hw7;

import edu.hw7.task1.Incrementer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        int numberThreads = 5;
        int incrementRes = 100;
        int res = numberThreads * incrementRes;

        Incrementer incrementer = new Incrementer(0);
        Thread[] threads = new Thread[5];

        for (int i = 0; i < numberThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementRes; j++) {
                    incrementer.increment();
                }
            });
        }

        for (Thread thread: threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        assertThat(incrementer.getValue()).isEqualTo(res);
    }
}
