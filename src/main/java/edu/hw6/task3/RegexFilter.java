package edu.hw6.task3;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public interface RegexFilter extends AbstractFilter {
    @NotNull static AbstractFilter regexContains(String regex) {
        Pattern pattern = Pattern.compile(regex);

        return path -> pattern.matcher(path.getFileName().toString()).find();
    }
}
