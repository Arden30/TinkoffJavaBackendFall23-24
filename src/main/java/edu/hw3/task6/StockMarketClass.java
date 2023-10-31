package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockMarketClass implements StockMarket {

    private final Queue<Stock> stocks = new PriorityQueue<>(Comparator.reverseOrder());

    public void add(Stock stock) {
        stocks.add(stock);
    }

    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
