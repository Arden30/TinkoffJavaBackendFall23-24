package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.StockMarket;
import edu.hw3.task6.StockMarketClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Test 1 (add + mostValuable)")
    void test1() {
        Stock stock1 = new Stock("Apple", 1000);
        Stock stock2 = new Stock("Huawei", 1500);
        Stock stock3 = new Stock("Samsung", 900);
        StockMarket stockMarket = new StockMarketClass();
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        assertThat(stockMarket.mostValuableStock()).isEqualTo(stock2);
    }

    @Test
    @DisplayName("Test 2 (add + remove + mostValuable)")
    void test2() {
        Stock stock1 = new Stock("Apple", 1000);
        Stock stock2 = new Stock("Huawei", 1500);
        Stock stock3 = new Stock("Samsung", 900);
        StockMarket stockMarket = new StockMarketClass();
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);

        stockMarket.remove(stock2);

        assertThat(stockMarket.mostValuableStock()).isEqualTo(stock1);
    }

    @Test
    @DisplayName("Test 3 (null)")
    void test3() {
        StockMarket stockMarket = new StockMarketClass();
        Stock stock1 = new Stock("Apple", 1000);
        stockMarket.add(stock1);
        stockMarket.remove(stock1);
        assertThat(stockMarket.mostValuableStock()).isEqualTo(null);
    }
}
