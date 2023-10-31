package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 {
    private Task8() {

    }

    public static Optional<Animal> heaviestBelowHeight(List<Animal> list, int k) {
        return list.stream()
            .filter(l -> l.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }
}
