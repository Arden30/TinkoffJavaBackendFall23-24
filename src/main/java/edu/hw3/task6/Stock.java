package edu.hw3.task6;

import org.jetbrains.annotations.NotNull;

public record Stock(String company, int price) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock stock) {
        return Integer.compare(price, stock.price());
    }
}
