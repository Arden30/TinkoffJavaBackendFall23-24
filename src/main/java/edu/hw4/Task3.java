package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    private Task3() {

    }

    public static Map<Animal.Type, Long> typesSorter(List<Animal> list) {
        return list.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }
}
