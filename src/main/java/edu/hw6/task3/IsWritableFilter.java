package edu.hw6.task3;

import java.nio.file.Files;

public interface IsWritableFilter extends AbstractFilter {
    static AbstractFilter isWritable() {
        return Files::isWritable;
    }
}
