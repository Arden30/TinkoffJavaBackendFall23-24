package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 10, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 2, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 30, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 5, true));
        return list;
    }

    static List<Animal> sortedAnimals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 30, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 10, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 5, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 2, true));
        return list;
    }

    static List<Animal> sortedLimitedAnimals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 30, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true));
        return list;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task2.weightSorter(animals(), 6)).isEqualTo(sortedAnimals());
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        assertThat(Task2.weightSorter(animals(), 3)).isEqualTo(sortedLimitedAnimals());
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        assertThat(Task2.weightSorter(animals(), 0)).isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Test 4")
    void test4() {
        assertThat(Task2.weightSorter(animals(), -5)).isEqualTo(Collections.emptyList());
    }
}
