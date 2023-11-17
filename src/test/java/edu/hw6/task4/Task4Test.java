package edu.hw6.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        Path path = Path.of("src/test/java/edu/hw6/task4/composition.txt");
        OutputStreamComposition outputStreamComposition = new OutputStreamComposition();
        outputStreamComposition.createComposition(path);

        String expected = "Programming is learned by writing programs. ― Brian Kernighan";

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str = reader.readLine();
            assertThat(str).isEqualTo(expected);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
