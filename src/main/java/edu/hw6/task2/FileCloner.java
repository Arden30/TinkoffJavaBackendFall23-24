package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCloner {
    private FileCloner() {

    }

    private final static String COPY = " - копия";
    private final static String PATTERN = "\\.";

    public static void cloneFile(Path path) {
        try {
            String file = path.getFileName().toString();
            String[] arrSpl = file.split(PATTERN);
            String fileName = arrSpl[0];
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < arrSpl.length; i++) {
                stringBuilder.append(".").append(file.split(PATTERN)[i]);
            }
            String extension = stringBuilder.toString();

            String copyName = fileName + COPY + extension;
            Path parent = path.getParent();
            Path copyPath = Path.of(parent + "\\" + copyName);

            int count = 2;
            while (Files.exists(copyPath)) {
                copyName = fileName + COPY + " (" + count + ")" + extension;
                copyPath = Path.of(parent + "\\" + copyName);
                count++;
            }

            Files.copy(path, copyPath);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
