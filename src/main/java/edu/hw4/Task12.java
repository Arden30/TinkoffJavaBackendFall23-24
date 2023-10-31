package edu.hw4;

import java.util.List;

public class Task12 {

    private Task12() {

    }

    public static Integer weightBiggerThanHeight(List<Animal> list) {
        return ((int) list.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());
    }
}
