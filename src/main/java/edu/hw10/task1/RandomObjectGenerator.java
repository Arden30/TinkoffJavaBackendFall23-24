package edu.hw10.task1;

import edu.hw10.task1.generators.DoubleGenerator;
import edu.hw10.task1.generators.Generator;
import edu.hw10.task1.generators.StringGenerator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RandomObjectGenerator {
    private static final List<Generator> GENERATORS = new ArrayList<>();

    public RandomObjectGenerator() {
        GENERATORS.addAll(List.of(new DoubleGenerator(), new StringGenerator()));
    }

    public Object nextObject(Class<?> target)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        var constructor = Arrays.stream(target.getDeclaredConstructors())
            .max(Comparator.comparingInt(Constructor::getParameterCount))
            .orElseThrow();

        return constructor.newInstance(getArgs(constructor));
    }

    public Object nextObject(Class<?> target, String methodName)
        throws InvocationTargetException,
        IllegalAccessException {

        Method method = Arrays.stream(target.getDeclaredMethods())
            .filter(meth -> meth.getName().equals(methodName))
            .findFirst()
            .orElseThrow();

        return method.invoke(null, getArgs(method));
    }

    private Object[] getArgs(Executable method) {
        Parameter[] parameters = method.getParameters();

        Object[] args = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            int j = 0;
            do {
                args[i] = GENERATORS.get(j++).generate(parameters[i]);
            } while (args[i] == null);
        }

        return args;
    }
}
