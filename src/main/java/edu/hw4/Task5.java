package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {

    private Task5() {

    }

    public static Animal.Sex sexCounter(List<Animal> list) {
        var map = list.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));
        Long cntM = map.getOrDefault(Animal.Sex.M, 0L);
        Long cntF = map.getOrDefault(Animal.Sex.F, 0L);
        if (cntF.equals(cntM)) {
            return null;
        } else {
            return cntM > cntF ? Animal.Sex.M : Animal.Sex.F;
        }
    }
}
