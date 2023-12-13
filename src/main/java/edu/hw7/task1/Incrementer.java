package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer {
    private final AtomicInteger value;

    public Incrementer(int val) {
        value = new AtomicInteger(val);
    }

    public int getValue() {
        return value.intValue();
    }

    public void increment() {
        value.getAndIncrement();
    }
}
