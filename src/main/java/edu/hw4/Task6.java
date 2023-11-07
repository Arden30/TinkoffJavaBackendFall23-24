package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {

    private Task6() {

    }

    public static Map<Animal.Type, Animal> heaviest(List<Animal> list) {
        return list.stream()
            .collect(Collectors.groupingBy(
                Animal::type, Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingInt(Animal::weight)), optional -> optional.orElse(null))));
    }
}
