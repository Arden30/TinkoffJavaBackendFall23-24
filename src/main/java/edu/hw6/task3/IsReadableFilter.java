package edu.hw6.task3;

import java.nio.file.Files;

public interface IsReadableFilter extends AbstractFilter {
    static AbstractFilter isReadable() {
        return Files::isReadable;
    }
}
