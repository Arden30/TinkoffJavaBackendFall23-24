package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    static List<Animal> animals() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 15, 15, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 10, 10, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 2, 2, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 20, 30, true),
            new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 8, 5, true));
        return list;
    }

    static Animal heaviestAnimalBelow10() {
        return new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 5, 20, true);
    }

    static Animal heaviestAnimalBelow100() {
        return new Animal("Johny", Animal.Type.CAT, Animal.Sex.M, 1, 20, 30, true);
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task8.heaviestBelowHeight(animals(), 10).orElse(null)).isEqualTo(heaviestAnimalBelow10());
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        assertThat(Task8.heaviestBelowHeight(animals(), 100).orElse(null)).isEqualTo(heaviestAnimalBelow100());
    }

    @Test
    @DisplayName("Test 3 (null)")
    void test3() {
        assertThat(Task8.heaviestBelowHeight(animals(), 0).orElse(null)).isEqualTo(null);
    }

}
