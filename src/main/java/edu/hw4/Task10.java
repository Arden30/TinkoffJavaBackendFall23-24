package edu.hw4;

import java.util.List;

public class Task10 {

    private Task10() {

    }

    public static List<Animal> pawsAndAge(List<Animal> list) {
        return list.stream()
            .filter(animal -> animal.paws() != animal.age())
            .toList();
    }
}
