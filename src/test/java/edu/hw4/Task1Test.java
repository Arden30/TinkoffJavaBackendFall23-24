package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 1, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 15, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 10, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 2, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 1, 15, true));
        return list;
    }

    static List<Animal> sortedAnimals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 1, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 1, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 2, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 10, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 15, 15, true));
        return list;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task1.sizeSorter(animals())).isEqualTo(sortedAnimals());
    }
}
