package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 3, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 2, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 10, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 5, 5, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 8, 5, 15, true));
        return list;
    }

    static Animal oldAnimal() {
        return new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 10, 5, 15, true);
    }

    static Animal middleAgedAnimal() {
        return new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 5, 5, 15, true);
    }

    static Animal youngAnimal() {
        return new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 15, true);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task7.ageSorter(animals(), 1)).isEqualTo(oldAnimal());
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        assertThat(Task7.ageSorter(animals(), 3)).isEqualTo(middleAgedAnimal());
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        assertThat(Task7.ageSorter(animals(), 6)).isEqualTo(youngAnimal());
    }

    @Test
    @DisplayName("Test 4 (null)")
    void test4() {
        assertThat(Task7.ageSorter(animals(), -5)).isEqualTo(null);
    }
}
