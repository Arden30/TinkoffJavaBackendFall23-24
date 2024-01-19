package edu.hw6.task3;

import org.jetbrains.annotations.NotNull;

public interface GlobFilter {
    @NotNull static AbstractFilter globMatches(String extension) {
        return path -> path.toString().endsWith(extension.substring(1));
    }
}
