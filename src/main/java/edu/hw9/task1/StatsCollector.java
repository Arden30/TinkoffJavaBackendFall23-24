package edu.hw9.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatsCollector {
    private final Queue<Metric> metrics = new ConcurrentLinkedQueue<>();
    private final ExecutorService executorService;

    public StatsCollector(int numOfThreads) {
        executorService = Executors.newFixedThreadPool(numOfThreads);
    }

    public void push(String name, double[] data) {
        executorService.execute(createMetric(name, data));
    }

    public List<Metric> stats() {
        return new ArrayList<>(metrics);
    }

    public Runnable createMetric(String name, double[] data) {
        return () -> {
            double sum = Arrays.stream(data).sum();
            double avg = Arrays.stream(data).average().orElse(0);
            double min = Arrays.stream(data).min().orElse(0);
            double max = Arrays.stream(data).max().orElse(0);
            Metric metric = new Metric(name, sum, avg, min, max);
            metrics.add(metric);
        };
    }
}
