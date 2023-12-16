package edu.hw10.task1;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;

public class CreditAccount {
    @NotNull
    private final String name;

    @Min(0)
    @Max(10000000)
    private final double sum;

    public CreditAccount(
        @NotNull String name,
        @Min(0)
        @Max(10000000)
        double sum
    ) {
        this.name = name;
        this.sum = sum;
    }

    public static CreditAccount create(
        @NotNull String name,
        @Min(0)
        @Max(10000000)
        double sum
    ) {
        return new CreditAccount(name, sum);
    }

    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }

    @Override public String toString() {
        return "CreditAccount{" +
            "name='" + name + '\'' +
            ", sum=" + sum +
            '}';
    }
}
