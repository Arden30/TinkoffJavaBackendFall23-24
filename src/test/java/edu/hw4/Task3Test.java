package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 10, true),
            new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 2, true),
            new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 30, true),
            new Animal("Johny", Animal.Type.BIRD, Animal.Sex.M, 1, 5, 5, true));
        return list;
    }

    static Map<Animal.Type, Long> groupedAnimals() {
        Map<Animal.Type, Long> map = new HashMap<>();
        map.put(Animal.Type.CAT, 3L);
        map.put(Animal.Type.DOG, 2L);
        map.put(Animal.Type.BIRD, 1L);
        return map;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task3.typesSorter(animals())).isEqualTo(groupedAnimals());
    }

}
