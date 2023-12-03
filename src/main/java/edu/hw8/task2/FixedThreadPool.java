package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int threadsNum;
    private final BlockingQueue<Runnable> blockingQueue;
    private final Thread[] threads;

    public FixedThreadPool(int threadsNum) {
        this.threadsNum = threadsNum;
        blockingQueue = new LinkedBlockingQueue<>();
        threads = new Thread[threadsNum];
    }

    public FixedThreadPool create(int threadsNum) {
        return new FixedThreadPool(threadsNum);
    }

    @Override
    public void start() {
        for (int i = 0; i < threadsNum; i++) {
            threads[i] = new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Runnable task = blockingQueue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            blockingQueue.put(runnable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
