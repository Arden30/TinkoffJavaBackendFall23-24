package edu.hw6.task3;

import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;

public interface IsWritableFilter extends AbstractFilter {
    @NotNull static AbstractFilter isWritable() {
        return Files::isWritable;
    }
}
