package edu.hw4;

import edu.hw4.task19_20.ValidationError;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task20 {

    private Task20() {

    }

    public static Map<String, String> validateErrorsWithMessages(List<Animal> list) {
        Map<String, Set<ValidationError>> map = Task19.validateErrors(list);

        return map.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                .map(ValidationError::getMessage).collect(Collectors.joining(";"))));
    }
}
