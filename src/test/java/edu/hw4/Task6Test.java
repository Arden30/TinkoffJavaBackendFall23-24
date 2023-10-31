package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Mark", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true),
            new Animal("Bill", Animal.Type.CAT, Animal.Sex.M, 1, 5, 10, true),
            new Animal("Alexander", Animal.Type.DOG, Animal.Sex.M, 1, 5, 2, true),
            new Animal("Julia", Animal.Type.DOG, Animal.Sex.F, 1, 5, 30, true),
            new Animal("Marie", Animal.Type.BIRD, Animal.Sex.F, 1, 5, 5, true));
        return list;
    }

    static Map<Animal.Type, Animal> animalsHeaviest() {
        Map<Animal.Type, Animal> map = new HashMap<>();
        map.put(Animal.Type.CAT, new Animal("Mark", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true));
        map.put(Animal.Type.DOG, new Animal("Julia", Animal.Type.DOG, Animal.Sex.F, 1, 5, 30, true));
        map.put(Animal.Type.BIRD, new Animal("Marie", Animal.Type.BIRD, Animal.Sex.F, 1, 5, 5, true));
        return map;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task6.heaviest(animals())).isEqualTo(animalsHeaviest());
    }

}
