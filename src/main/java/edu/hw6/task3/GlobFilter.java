package edu.hw6.task3;

public interface GlobFilter {
    static AbstractFilter globMatches(String extension) {
        return path -> path.toString().endsWith(extension.substring(1));
    }
}
