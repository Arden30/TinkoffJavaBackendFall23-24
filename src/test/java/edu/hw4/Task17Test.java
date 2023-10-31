package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    static List<Animal> spiders() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny Boston", Animal.Type.CAT, Animal.Sex.M, 4, 1, 15, true),
            new Animal("Johny     Walker", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, true),
            new Animal("Johny_one_word_name", Animal.Type.SPIDER, Animal.Sex.M, 8, 10, 4, true),
            new Animal("  ", Animal.Type.FISH, Animal.Sex.M, 10, 2, 15, true),
            new Animal("! +", Animal.Type.BIRD, Animal.Sex.M, 15, 1, 15, true));
        return list;
    }

    static List<Animal> equal() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny Boston", Animal.Type.CAT, Animal.Sex.M, 4, 1, 15, true),
            new Animal("Johny     Walker", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, false),
            new Animal("Johny_one_word_name", Animal.Type.SPIDER, Animal.Sex.M, 8, 10, 4, true),
            new Animal("  ", Animal.Type.FISH, Animal.Sex.M, 10, 2, 15, true),
            new Animal("! +", Animal.Type.BIRD, Animal.Sex.M, 15, 1, 15, true));
        return list;
    }

    static List<Animal> dogs() {
        List<Animal> list = new ArrayList<>();
        Collections.addAll(list, new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny Boston", Animal.Type.CAT, Animal.Sex.M, 4, 1, 15, true),
            new Animal("Johny     Walker", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, false),
            new Animal("Johny_one_word_name", Animal.Type.SPIDER, Animal.Sex.M, 8, 10, 4, false),
            new Animal("  ", Animal.Type.FISH, Animal.Sex.M, 10, 2, 15, true),
            new Animal("! +", Animal.Type.BIRD, Animal.Sex.M, 15, 1, 15, true));
        return list;
    }

    @Test
    @DisplayName("Test 1 (spiders)")
    void test1() {
        assertThat(Task17.areSpidersBiterThanDogs(spiders())).isEqualTo(true);
    }

    @Test
    @DisplayName("Test 2 (no one)")
    void test2() {
        assertThat(Task17.areSpidersBiterThanDogs(equal())).isEqualTo(false);
    }

    @Test
    @DisplayName("Test 3 (dogs)")
    void test3() {
        assertThat(Task17.areSpidersBiterThanDogs(dogs())).isEqualTo(false);
    }
}
