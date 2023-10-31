package edu.hw4;

import java.util.List;

public class Task17 {

    private Task17() {

    }

    public static Boolean areSpidersBiterThanDogs(List<Animal> list) {
        long dogs = list.stream()
            .filter(animal -> animal.type().equals(Animal.Type.DOG) && animal.bites())
            .count();
        long spiders = list.stream()
            .filter(animal -> animal.type().equals(Animal.Type.SPIDER) && animal.bites())
            .count();
        return spiders > dogs;
    }
}
