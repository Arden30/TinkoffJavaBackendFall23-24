package edu.hw4;

import java.util.List;

public class Task13 {

    private Task13() {

    }

    public static List<Animal> twoWordName(List<Animal> list) {
        return list.stream()
            .filter(animal -> animal.name().trim().split("\\s+").length > 1)
            .toList();
    }
}
