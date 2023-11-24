package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloMultithreading extends Thread {
    private double circleCount = 0;
    private double totalCount = 0;
    private final long n;

    public MonteCarloMultithreading(long n) {
        this.n = n;
    }

    @Override
    public void run() {
        double r = 1;
        while (totalCount++ < n) {
            double x = ThreadLocalRandom.current().nextDouble(0, 2 * r);
            double y = ThreadLocalRandom.current().nextDouble(0, 2 * r);

            if ((x - r) * (x - r) + (y - r) * (y - r) <= r * r) {
                circleCount++;
            }
        }
    }

    public double getCircleCount() {
        return circleCount;
    }
}
