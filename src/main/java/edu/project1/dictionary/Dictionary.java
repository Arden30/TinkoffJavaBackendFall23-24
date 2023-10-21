package edu.project1.dictionary;

import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface Dictionary {
    List<String> WORDS = Arrays.asList("hello", "bye", "ooo", "java", "you_will_never_guess_this_word!!");

    @NotNull String randomWord();
}
