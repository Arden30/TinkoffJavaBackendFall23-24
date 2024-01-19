package edu.hw6.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private final Path path = Path.of("src/test/java/edu/hw6/task1/disk.txt");

    @Test
    @DisplayName("Test 1 (saving)")
    void test1() throws IOException {
        DiskMap diskMap = new DiskMap(path);
        diskMap.put("hi", "java");
        diskMap.put("bye", "phyton");
        diskMap.saveToFile();

        String[] expected = {"hi:java", "bye:phyton"};
        boolean flag = true;

        try (BufferedReader reader = Files.newBufferedReader(diskMap.getPath())) {
            String str;
            int i = 0;
            while ((str = reader.readLine()) != null) {
                if (!expected[i++].equals(str)) {
                    flag = false;
                    break;
                }
            }
        } catch (IOException e) {
            return;
        }

        assertThat(flag).isEqualTo(true);
    }

    @Test
    @DisplayName("Test 2 (downloading)")
    void test2() throws IOException{
        DiskMap diskMap = new DiskMap(path);
        diskMap.downloadFromFile();
        diskMap.put("hello", "world");

        Map<String, String> expected = Map.of(
            "hi", "java",
            "bye", "phyton",
            "hello", "world"
        );

        assertThat(diskMap.entrySet()).isEqualTo(expected.entrySet());
    }
}
