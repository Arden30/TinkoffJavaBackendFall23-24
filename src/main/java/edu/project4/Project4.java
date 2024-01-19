package edu.project4;

import edu.project4.fractals.FractalGenerator;
import edu.project4.image.ImageFormat;
import java.nio.file.Path;

@SuppressWarnings("UncommentedMain")
public class Project4 {

    private final static int NUM_OF_THREADS = 30;

    private Project4() {
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/java/edu/project4/results/");
        String filename = "test.";
        FractalGenerator fractalGenerator = new FractalGenerator();
        fractalGenerator.launch(path, filename, ImageFormat.JPEG, NUM_OF_THREADS);
    }
}
