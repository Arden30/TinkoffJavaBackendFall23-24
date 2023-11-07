package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task11Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 95, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 4, 102, 15, true),
            new Animal("Johny", Animal.Type.SPIDER, Animal.Sex.M, 1, 15, 15, true),
            new Animal("Johny", Animal.Type.SPIDER, Animal.Sex.M, 8, 103, 15, false),
            new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 101, 15, true),
            new Animal("Johny", Animal.Type.BIRD, Animal.Sex.M, 1, 1, 15, true));
        return list;
    }

    static List<Animal> filteredAnimals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 4, 102, 15, true),
            new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 101, 15, true));
        return list;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task11.canBite(animals())).isEqualTo(filteredAnimals());
    }
}
