package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {
    static List<List<Animal>> animals() {
        List<Animal> list1 = new ArrayList<>();
        Collections.addAll(list1, new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny Boston", Animal.Type.CAT, Animal.Sex.M, 4, 1, 15, true),
            new Animal("Johny     Walker", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, true),
            new Animal("Johny_one_word_name", Animal.Type.SPIDER, Animal.Sex.M, 8, 10, 4, true),
            new Animal("fish1", Animal.Type.FISH, Animal.Sex.M, 10, 2, 15, true),
            new Animal("! +", Animal.Type.BIRD, Animal.Sex.M, 15, 1, 15, true)
        );
        List<Animal> list2 = new ArrayList<>();
        Collections.addAll(list2, new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny Boston", Animal.Type.CAT, Animal.Sex.M, 4, 1, 15, true),
            new Animal("Johny     Walker", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, true),
            new Animal("Johny_one_word_name", Animal.Type.SPIDER, Animal.Sex.M, 8, 10, 4, true),
            new Animal("fish2", Animal.Type.FISH, Animal.Sex.M, 10, 2, 20, true),
            new Animal("! +", Animal.Type.BIRD, Animal.Sex.M, 15, 1, 15, true)
        );
        List<Animal> list3 = new ArrayList<>();
        Collections.addAll(list3, new Animal("Johny", Animal.Type.DOG, Animal.Sex.M, 1, 5, 15, true),
            new Animal("Johny Boston", Animal.Type.CAT, Animal.Sex.M, 4, 1, 15, true),
            new Animal("Johny     Walker", Animal.Type.SPIDER, Animal.Sex.M, 3, 15, 2, true),
            new Animal("Johny_one_word_name", Animal.Type.SPIDER, Animal.Sex.M, 8, 10, 4, true),
            new Animal("fish3", Animal.Type.FISH, Animal.Sex.M, 10, 2, 10, true),
            new Animal("! +", Animal.Type.BIRD, Animal.Sex.M, 15, 1, 15, true)
        );
        List<List<Animal>> list = new ArrayList<>();
        Collections.addAll(list, list1, list2, list3);
        return list;
    }

    @Test
    @DisplayName("Test 1")
    void test1() {
        assertThat(Task18.heavyFish(animals())).isEqualTo(new Animal(
            "fish2",
            Animal.Type.FISH,
            Animal.Sex.M,
            10,
            2,
            20,
            true
        ));
    }
}
