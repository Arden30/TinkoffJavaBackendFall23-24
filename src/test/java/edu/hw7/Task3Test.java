package edu.hw7;

import edu.hw7.task3_and_3_5.FinderService;
import edu.hw7.task3_and_3_5.Person;
import edu.hw7.task3_and_3_5.ReadWriteLockFinderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    private final ReadWriteLockFinderService readWriteLockFinderService = new ReadWriteLockFinderService();
    private final FinderService finderService = new FinderService();

    {
        for (int i = 0; i < 10; i++) {
            String name = Character.toString('a' + i);
            String address = Character.toString('A' + i);
            String phoneNumber = "1234567" + i;
            Person person = new Person(i, name, address, phoneNumber);
            finderService.add(person);
            readWriteLockFinderService.add(person);
        }
    }

    @Test
    @DisplayName("Test 1 (address)")
    void test1() {
        List<Person> expected = List.of(finderService.getBase().get(1));
        List<Person> res = finderService.findByAddress("B");
        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test 2 (delete)")
    void test2() {
        finderService.delete(0);
        List<Person> res = finderService.findByName("a");
        assertThat(res).isEqualTo(List.of());
    }

    @Test
    @DisplayName("Test 3 (phone)")
    void test3() {
        List<Person> expected = List.of(finderService.getBase().get(5));
        List<Person> res = finderService.findByPhone("12345675");
        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test 4 (ReadWriteLock - address)")
    void test4() {
        List<Person> expected = List.of(readWriteLockFinderService.getBase().get(1));
        List<Person> res = readWriteLockFinderService.findByAddress("B");
        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test 5 (ReadWriteLock - delete)")
    void test5() {
        readWriteLockFinderService.delete(0);
        List<Person> res = readWriteLockFinderService.findByName("a");
        assertThat(res).isEqualTo(List.of());
    }

    @Test
    @DisplayName("Test 6 (ReadWriteLock - phone)")
    void test6() {
        List<Person> expected = List.of(readWriteLockFinderService.getBase().get(5));
        List<Person> res = readWriteLockFinderService.findByPhone("12345675");
        assertThat(res).isEqualTo(expected);
    }
}
