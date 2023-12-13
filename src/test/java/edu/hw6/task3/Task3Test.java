package edu.hw6.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.task3.GlobFilter.globMatches;
import static edu.hw6.task3.RegexFilter.regexContains;
import static edu.hw6.task3.SizeFilter.largerThan;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    private static final AbstractFilter regularFile = Files::isRegularFile;
    private static final AbstractFilter readable = Files::isReadable;
    private static final Path DIR = Path.of("src/test/java/edu/hw6/task3");

    @Test
    @DisplayName("Test 1")
    void test1() {
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(largerThan(20))
            .and(globMatches("*.txt"))
            .and(regexContains("b"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(DIR, filter)) {
            assertThat(entries.iterator().next().getFileName().toString()).isEqualTo("bigSize.txt");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
