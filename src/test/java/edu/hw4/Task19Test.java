package edu.hw4;

import edu.hw4.task19_20.ValidationError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task19Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny1", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("M2ark", Animal.Type.CAT, Animal.Sex.M, -1, 5, 20, true),
            new Animal("   ", Animal.Type.CAT, Animal.Sex.M, 1, 5, -10, true),
            new Animal("123", Animal.Type.DOG, Animal.Sex.M, 1, -5, 2, true),
            new Animal("1Julia1", Animal.Type.DOG, Animal.Sex.F, -1, -5, -30, true),
            new Animal("Marie", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 5, true));
        return list;
    }

    static Map<String, Set<ValidationError>> errors() {
        Map<String, Set<ValidationError>> map = new HashMap<>();

        Set<ValidationError> set1 = new HashSet<>();
        Collections.addAll(set1, Task19.NAME_ERROR);

        Set<ValidationError> set2 = new HashSet<>();
        Collections.addAll(set2, Task19.NAME_ERROR, Task19.AGE_ERROR);

        Set<ValidationError> set3 = new HashSet<>();
        Collections.addAll(set3, Task19.NAME_ERROR, Task19.WEIGHT_ERROR);

        Set<ValidationError> set4 = new HashSet<>();
        Collections.addAll(set4, Task19.NAME_ERROR, Task19.HEIGHT_ERROR);

        Set<ValidationError> set5 = new HashSet<>();
        Collections.addAll(set5, Task19.NAME_ERROR, Task19.AGE_ERROR, Task19.HEIGHT_ERROR, Task19.WEIGHT_ERROR);

        map.put("Johny1", set1);
        map.put("M2ark", set2);
        map.put("   ", set3);
        map.put("123", set4);
        map.put("1Julia1", set5);

        return map;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task19.validateErrors(animals())).isEqualTo(errors());
    }
}
