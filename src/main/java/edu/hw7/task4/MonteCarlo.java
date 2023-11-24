package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;

public class MonteCarlo {
    private static final int RATIO = 4;

    private MonteCarlo() {

    }

    public static double countPI(long n) {
        double r = 1;
        double totalCount = 0;
        double circleCount = 0;

        while (totalCount++ < n) {
            double x = ThreadLocalRandom.current().nextDouble(0, 2 * r);
            double y = ThreadLocalRandom.current().nextDouble(0, 2 * r);

            if ((x - r) * (x - r) + (y - r) * (y - r) <= r * r) {
                circleCount++;
            }
        }

        return RATIO * (circleCount / totalCount);
    }

    public static double multiCountPI(long totalCount, int threads) {
        double circleCount = 0;
        long totalCountPerThread = totalCount / threads;
        var monteCarloMultithreading = new MonteCarloMultithreading[threads];

        for (int i = 0; i < threads; i++) {
            monteCarloMultithreading[i] = new MonteCarloMultithreading(totalCountPerThread);
            monteCarloMultithreading[i].start();
        }

        try {
            for (var thread : monteCarloMultithreading) {
                thread.join();
                circleCount += thread.getCircleCount();
            }
        } catch (InterruptedException e) {
            return 0;
        }

        return RATIO * (circleCount / totalCount);
    }
}
