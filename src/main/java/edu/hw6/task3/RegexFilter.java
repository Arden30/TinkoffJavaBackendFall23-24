package edu.hw6.task3;

import java.util.regex.Pattern;

public interface RegexFilter extends AbstractFilter {
    static AbstractFilter regexContains(String regex) {
        Pattern pattern = Pattern.compile(regex);

        return path -> pattern.matcher(path.getFileName().toString()).find();
    }
}
