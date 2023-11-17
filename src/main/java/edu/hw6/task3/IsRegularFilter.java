package edu.hw6.task3;

import java.nio.file.Files;

public interface IsRegularFilter extends AbstractFilter {
    static AbstractFilter isRegularFile() {
        return Files::isRegularFile;
    }
}
