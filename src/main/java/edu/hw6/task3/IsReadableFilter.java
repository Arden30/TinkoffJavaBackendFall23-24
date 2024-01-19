package edu.hw6.task3;

import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;

public interface IsReadableFilter extends AbstractFilter {
    @NotNull static AbstractFilter isReadable() {
        return Files::isReadable;
    }
}
