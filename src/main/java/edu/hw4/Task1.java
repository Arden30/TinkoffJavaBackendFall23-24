package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task1 {
    private Task1() {

    }

    public static List<Animal> sizeSorter(List<Animal> list) {
        return list.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }
}
