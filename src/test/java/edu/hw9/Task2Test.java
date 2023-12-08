package edu.hw9;

import edu.hw9.task2.DirectoriesAnalyzer;
import edu.hw9.task2.FilesAnalyzer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Test 1 (directories analyzer)")
    void test1() {
        List<String> expected = List.of(
            "src\\main\\java\\edu\\project3\\formatters",
            "src\\main\\java\\edu\\project3\\utils",
            "src\\main\\java\\edu\\project3"
        );

        Path root = Path.of("src/main/java/edu/project3");
        DirectoriesAnalyzer directoriesAnalyzer = new DirectoriesAnalyzer(root, 2);
        var res = directoriesAnalyzer.analyzeDirs();
        int i = 0;
        for (Path path: res.getKey()) {
            assertThat(expected.get(i++)).isEqualTo(path.toString());
        }
    }

    @Test
    @DisplayName("Test 2 (files analyzer)")
    void test2() {
        List<String> expected = List.of(
            "src\\test\\java\\edu\\project3\\test1.log"
        );

        Path root = Path.of("src/test/java/edu/project3");
        FilesAnalyzer filesAnalyzer = new FilesAnalyzer(root, 500, "log");
        var res = filesAnalyzer.analyzeFiles();
        int i = 0;
        for (Path path: res) {
            assertThat(expected.get(i++)).isEqualTo(path.toString());
        }
    }
}
