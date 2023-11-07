package edu.hw4;

import java.util.List;

public class Task14 {

    private Task14() {

    }

    public static Boolean isDogWithHeightAbove(List<Animal> list, int k) {
        return list.stream()
            .anyMatch(animal -> animal.type().equals(Animal.Type.DOG)
                && animal.height() > k);
    }
}
