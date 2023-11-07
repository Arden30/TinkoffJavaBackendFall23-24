package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task4 {

    private Task4() {

    }

    public static Animal typesSorter(List<Animal> list) {
        return list.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }
}
