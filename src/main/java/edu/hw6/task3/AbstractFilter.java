package edu.hw6.task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter abstractFilter) {
        return path -> this.accept(path) && abstractFilter.accept(path);
    }
}
