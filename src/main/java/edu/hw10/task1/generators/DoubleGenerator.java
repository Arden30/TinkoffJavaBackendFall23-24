package edu.hw10.task1.generators;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import java.lang.reflect.Parameter;
import java.util.concurrent.ThreadLocalRandom;

public class DoubleGenerator implements Generator {
    @Override
    public Object generate(Parameter parameter) {
        if (!parameter.getType().equals(double.class)) {
            return null;
        }

        double minValue = Double.MIN_VALUE;
        double maxValue = Integer.MAX_VALUE;
        for (var annotation : parameter.getAnnotations()) {
            if (annotation instanceof Max) {
                maxValue = ((Max) annotation).value();
            } else if (annotation instanceof Min) {
                minValue = ((Min) annotation).value();
            }
        }

        return ThreadLocalRandom.current().nextDouble(minValue, maxValue);
    }
}
