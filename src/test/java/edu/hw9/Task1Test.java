package edu.hw9;

import edu.hw9.task1.Metric;
import edu.hw9.task1.StatsCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private final Map<String, double[]> stats = Map.of(
        "first", new double[] { 0.0, 1.0, 2.0, 3.0, 4.0 },
        "second", new double[] { 5.0, 6.0, 7.0, 8.0, 9.0 },
        "third", new double[] { 0.123 },
        "fourth", new double[] { 0.0 }
    );

    private final List<Metric> expects = List.of(
        new Metric("first", 10.0, 2.0, 0.0, 4.0),
        new Metric("second", 35.0, 7.0, 5.0, 9.0),
        new Metric("third", 0.123, 0.123, 0.123, 0.123),
        new Metric("fourth", 0.0, 0.0, 0.0, 0.0)
    );

    @Test
    @DisplayName("Test 1")
    void test1() {
        int numOfThreads = 4;

        StatsCollector statsCollector = new StatsCollector(numOfThreads);
        Thread[] threads = new Thread[numOfThreads];
        int i = 0;

        for (var data: stats.entrySet()) {
            threads[i] = new Thread(() -> statsCollector.push(data.getKey(), data.getValue()));
            threads[i++].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Metric> metrics = statsCollector.stats();

        for (var metric: metrics) {
            var expected = expects.stream()
                .filter(e -> e.name().equals(metric.name()))
                .findFirst()
                .orElse(null);

            assert expected != null;
            assertThat(metric.name()).isEqualTo(expected.name());
            assertThat(metric.sum()).isEqualTo(expected.sum());
            assertThat(metric.avg()).isEqualTo(expected.avg());
            assertThat(metric.max()).isEqualTo(expected.max());
            assertThat(metric.min()).isEqualTo(expected.min());
        }
    }
}
