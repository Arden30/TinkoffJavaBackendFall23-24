package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {
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

    static Map<String, String> errors() {
        Map<String, String> map = new HashMap<>();

        map.put("Johny1", "Name must have letters only");
        map.put("M2ark", "Age is a positive number;Name must have letters only");
        map.put("   ", "Weight is a positive number;Name must have letters only");
        map.put("123", "Name must have letters only;Height is a positive number");
        map.put("1Julia1", "Weight is a positive number;Age is a positive number;Name must have letters only;Height is a positive number");

        return map;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task20.validateErrorsWithMessages(animals())).isEqualTo(errors());
    }
}
