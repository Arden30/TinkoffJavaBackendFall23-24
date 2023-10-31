package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task7 {

    private Task7() {

    }

    public static Animal ageSorter(List<Animal> list, int k) {
        if (k <= 0) {
            return null;
        }
        return list.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1).findFirst().orElse(null);
    }
}
