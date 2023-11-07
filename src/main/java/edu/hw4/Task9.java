package edu.hw4;

import java.util.List;

public class Task9 {

    private Task9() {

    }

    public static Integer pawsSum(List<Animal> list) {
        return list.stream()
            .mapToInt(Animal::paws)
            .sum();
    }
}
