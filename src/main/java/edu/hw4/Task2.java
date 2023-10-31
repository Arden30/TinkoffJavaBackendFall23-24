package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    public static List<Animal> weightSorter(List<Animal> list, int k) {
        if (k <= 0) {
            return Collections.emptyList();
        }
        return list.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }
}
