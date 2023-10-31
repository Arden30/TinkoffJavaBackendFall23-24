package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task18 {

    private Task18() {

    }

    public static Animal heavyFish(List<List<Animal>> lists) {
        return lists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
