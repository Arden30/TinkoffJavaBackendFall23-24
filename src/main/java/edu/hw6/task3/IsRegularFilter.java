package edu.hw6.task3;

import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;

public interface IsRegularFilter extends AbstractFilter {
    @NotNull static AbstractFilter isRegularFile() {
        return Files::isRegularFile;
    }
}
