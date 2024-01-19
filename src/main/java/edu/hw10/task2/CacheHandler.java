package edu.hw10.task2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheHandler implements InvocationHandler {
    private final Object target;
    private Map<String, HashMap<List<Object>, Object>> cache = new HashMap<>();
    private final Path path;

    public CacheHandler(Object target, Path path) {
        this.target = target;
        this.path = path;

        for (var method : target.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Cache.class)) {
                cache.putIfAbsent(method.getName(), new HashMap<>());
            }
        }

        load();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> argsList = Arrays.asList(args);
        if (method.isAnnotationPresent(Cache.class)) {
            var results = cache.get(method.getName());
            Object res = method.invoke(target, args);

            if (results.containsKey(argsList)) {
                return results.get(argsList);
            }

            results.put(argsList, res);

            save();

            return res;
        }

        return method.invoke(target, args);
    }

    public void save() {
        Map<String, HashMap<List<Object>, Object>> persist = new HashMap<>();
        for (var method : target.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Cache.class) && method.getAnnotation(Cache.class).persist()) {
                persist.putIfAbsent(method.getName(), cache.get(method.getName()));
            }
        }

        try (var objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE))) {
            objectOutputStream.writeObject(persist);
        } catch (IOException e) {
            throw new RuntimeException("Can't save data in cache");
        }
    }

    public void load() {
        if (Files.exists(path)) {
            try (var objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
                Object obj = objectInputStream.readObject();
                if (obj instanceof Map) {
                    cache = (Map<String, HashMap<List<Object>, Object>>) obj;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("Can't load data from cache");
            }
        }
    }

    public Map<String, HashMap<List<Object>, Object>> getCache() {
        return cache;
    }
}
