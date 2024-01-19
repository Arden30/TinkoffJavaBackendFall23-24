package edu.hw4;

import edu.hw4.task19_20.AgeError;
import edu.hw4.task19_20.HeightError;
import edu.hw4.task19_20.NameError;
import edu.hw4.task19_20.ValidationError;
import edu.hw4.task19_20.WeightError;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task19 {

    private Task19() {

    }

    public final static ValidationError NAME_ERROR = new NameError("Name must have letters only");
    public final static ValidationError AGE_ERROR = new AgeError("Age is a positive number");
    public final static ValidationError HEIGHT_ERROR = new HeightError("Height is a positive number");
    public final static ValidationError WEIGHT_ERROR = new WeightError("Weight is a positive number");

    public static Set<ValidationError> getError(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (!animal.name().matches("[a-zA-Z]+")) {
            errors.add(NAME_ERROR);
        }
        if (animal.age() <= 0) {
            errors.add(AGE_ERROR);
        }
        if (animal.height() <= 0) {
            errors.add(HEIGHT_ERROR);
        }
        if (animal.weight() <= 0) {
            errors.add(WEIGHT_ERROR);
        }
        return errors;
    }

    public static Map<String, Set<ValidationError>> validateErrors(List<Animal> list) {
        return list.stream()
            .collect(Collectors.toMap(Animal::name, Task19::getError))
            .entrySet().stream()
            .filter(err -> !err.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
