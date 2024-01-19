package edu.hw10.task1;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;

public record CreditRec(@NotNull String name,
                        @Min(0)
                        @Max(10000000)
                        double sum) {
}
