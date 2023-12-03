package edu.hw8;

import edu.hw8.task3.PasswordDB;
import edu.hw8.task3.PasswordEnumerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Test 1 (single Thread)")
    void test1() {
        PasswordDB passwordDB = new PasswordDB("src/test/java/edu/hw8/password.txt");
        PasswordEnumerator passwordEnumerator = new PasswordEnumerator(passwordDB, 4);

        long start = System.nanoTime();
        Map<String, String> res = passwordEnumerator.nextPasswordSingleThread();
        double timeSingle = (System.nanoTime() - start) / 1_000_000_000.0;
        System.out.println("Single thread time: " + timeSingle + " sec");

        Map<String, String> expected = Map.of(
            "a01", "a.s.ivanov",
            "1234", "a.v.petrov");

        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test 2 (multithreading, 5 threads)")
    void test2() {
        PasswordDB passwordDB = new PasswordDB("src/test/java/edu/hw8/password.txt");
        PasswordEnumerator passwordEnumerator = new PasswordEnumerator(passwordDB, 4);

        long start = System.nanoTime();
        Map<String, String> res = passwordEnumerator.nextPasswordMultithreading(5);
        double timeMulti = (System.nanoTime() - start) / 1_000_000_000.0;

        Map<String, String> expected = Map.of(
            "a01", "a.s.ivanov",
            "1234", "a.v.petrov");

        assertThat(res).isEqualTo(expected);

        System.out.println("Multithreading time (5 threads): " + timeMulti + " sec");
    }

    @Test
    @DisplayName("Test 3 (multithreading, 15 threads)")
    void test3() {
        PasswordDB passwordDB = new PasswordDB("src/test/java/edu/hw8/password.txt");
        PasswordEnumerator passwordEnumerator = new PasswordEnumerator(passwordDB, 4);

        long start = System.nanoTime();
        Map<String, String> res = passwordEnumerator.nextPasswordMultithreading(15);
        double timeMulti = (System.nanoTime() - start) / 1_000_000_000.0;

        Map<String, String> expected = Map.of(
            "a01", "a.s.ivanov",
            "1234", "a.v.petrov");

        assertThat(res).isEqualTo(expected);

        System.out.println("Multithreading time(15 threads): " + timeMulti + " sec");
    }

    @Test
    @DisplayName("Test 4 (multithreading, 50 threads)")
    void test4() {
        PasswordDB passwordDB = new PasswordDB("src/test/java/edu/hw8/password.txt");
        PasswordEnumerator passwordEnumerator = new PasswordEnumerator(passwordDB, 4);

        long start = System.nanoTime();
        Map<String, String> res = passwordEnumerator.nextPasswordMultithreading(50);
        double timeMulti = (System.nanoTime() - start) / 1_000_000_000.0;

        Map<String, String> expected = Map.of(
            "a01", "a.s.ivanov",
            "1234", "a.v.petrov");

        assertThat(res).isEqualTo(expected);

        System.out.println("Multithreading time(50 threads): " + timeMulti + " sec");
    }
}
