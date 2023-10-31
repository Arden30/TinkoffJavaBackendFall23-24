package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task15Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny Boston", Animal.Type.CAT, Animal.Sex.M, 4, 1, 15, true),
            new Animal("Johny     Walker", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, true),
            new Animal("Johny_one_word_name", Animal.Type.SPIDER, Animal.Sex.M, 8, 10, 4, true),
            new Animal("  ", Animal.Type.FISH, Animal.Sex.M, 10, 2, 15, true),
            new Animal("! +", Animal.Type.BIRD, Animal.Sex.M, 15, 1, 15, true));
        return list;
    }

    static Map<Animal.Type, Integer> sum() {
        Map<Animal.Type, Integer> map = new HashMap<>();
        map.put(Animal.Type.CAT, 15);
        map.put(Animal.Type.SPIDER, 6);
        return map;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task15.ageBetweenNumbers(animals(), 2, 8)).isEqualTo(sum());
    }

}
