package edu.hw4;

import java.util.List;

public class Task11 {

    private Task11() {

    }

    public final static int MIN_HEIGHT = 100;

    public static List<Animal> canBite(List<Animal> list) {
        return list.stream()
            .filter(animal -> animal.bites() && animal.height() >= MIN_HEIGHT)
            .toList();
    }
}
