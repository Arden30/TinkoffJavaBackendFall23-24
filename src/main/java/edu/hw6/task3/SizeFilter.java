package edu.hw6.task3;

import java.nio.file.Files;
import org.jetbrains.annotations.NotNull;

public interface SizeFilter extends AbstractFilter {
    @NotNull static AbstractFilter largerThan(long size) {
        return path -> Files.size(path) > size;
    }
}
