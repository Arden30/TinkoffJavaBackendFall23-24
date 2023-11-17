package edu.hw6.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Path path = Path.of("src/test/java/edu/hw6/task2/file.txt");
        Path copy = Path.of("src/test/java/edu/hw6/task2/file - копия.txt");
        Path copy2 = Path.of("src/test/java/edu/hw6/task2/file - копия (2).txt");
        Path copy3 = Path.of("src/test/java/edu/hw6/task2/file - копия (3).txt");

        FileCloner.cloneFile(path);
        FileCloner.cloneFile(path);
        FileCloner.cloneFile(path);

        assertThat(Files.exists(copy)).isTrue();
        assertThat(Files.exists(copy2)).isTrue();
        assertThat(Files.exists(copy3)).isTrue();

        try {
            Files.delete(copy);
            Files.delete(copy2);
            Files.delete(copy3);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
