package edu.project4;

import edu.project4.fractals.FractalGenerator;
import edu.project4.image.ImageFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;

public class Project4Test {
    private final Path path = Path.of("src/test/java/edu/project4/results/");
    private final String filename = "test.";

    @Test
    @DisplayName("Test single thread version")
    void testSingleThread() {
        long start = System.nanoTime();
        FractalGenerator fractalGenerator = new FractalGenerator();
        fractalGenerator.launch(path, filename, ImageFormat.JPEG, 1);
        System.out.println("Single thread generating time: " + ((System.nanoTime() - start) / 1_000_000_000.0) + " sec");
    }

    @Test
    @DisplayName("Test multi thread version (10)")
    void testMultiThread10() {
        long start = System.nanoTime();
        FractalGenerator fractalGenerator = new FractalGenerator();
        fractalGenerator.launch(path, filename, ImageFormat.JPEG, 10);
        System.out.println("Multithreading generating time (10 threads): " + ((System.nanoTime() - start) / 1_000_000_000.0) + " sec");
    }

    @Test
    @DisplayName("Test multi thread version (20)")
    void testMultiThread20() {
        long start = System.nanoTime();
        FractalGenerator fractalGenerator = new FractalGenerator();
        fractalGenerator.launch(path, filename, ImageFormat.JPEG, 20);
        System.out.println("Multithreading generating time (20 threads): " + ((System.nanoTime() - start) / 1_000_000_000.0) + " sec");
    }

    @Test
    @DisplayName("Test multi thread version (50)")
    void testMultiThread50() {
        long start = System.nanoTime();
        FractalGenerator fractalGenerator = new FractalGenerator();
        fractalGenerator.launch(path, filename, ImageFormat.JPEG, 50);
        System.out.println("Multithreading generating time (50 threads): " + ((System.nanoTime() - start) / 1_000_000_000.0) + " sec");
    }
}
