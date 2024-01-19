package edu.hw10.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    private final Path path = Path.of("src/test/java/edu/hw10/cache.txt");
    private static final long[] FIBONACCI_NUMBERS = {
        0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L
    };

    @Test
    @DisplayName("Test 1")
    void test1() throws IOException {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxy = (FibCalculator) CacheProxy.create(fibCalculator, fibCalculator.getClass(), path);

        int n = 9;
        long res1 = proxy.fib(n);
        long res2 = proxy.fib(n - 1);
        long res3 = proxy.fib(n - 2);
        long res4 = proxy.fib(n - 3);

        assertThat(FIBONACCI_NUMBERS).contains(res1, res2, res3, res4);

        var cacheHandler = new CacheHandler(fibCalculator.getClass(), path);
        var cache = cacheHandler.getCache();

        for (Map.Entry<String, HashMap<List<Object>, Object>> entry: cache.entrySet()) {
            for (Map.Entry<List<Object>, Object> result: entry.getValue().entrySet()) {
                assertThat(FIBONACCI_NUMBERS).contains((long) result.getValue());
            }
        }

        Files.delete(path);
    }
}
