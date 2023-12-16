package edu.hw10.task1.generators;

import edu.hw10.task1.annotations.NotNull;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StringGenerator implements Generator {
    private static final List<String> WORDS = List.of(
        "AlexAccount", "DaveAccount", "MikeAccount"
    );

    @Override
    public Object generate(Parameter parameter) {
        if (!parameter.getType().equals(String.class)) {
            return null;
        }

        for (var annotation : parameter.getAnnotations()) {
            if (annotation instanceof NotNull) {
                return randomWord();
            }
        }

        return ThreadLocalRandom.current().nextBoolean()
            ? randomWord()
            : null;
    }

    private static String randomWord() {
        return WORDS.get(ThreadLocalRandom.current().nextInt(WORDS.size()));
    }
}
