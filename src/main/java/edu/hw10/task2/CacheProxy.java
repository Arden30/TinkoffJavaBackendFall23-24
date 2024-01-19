package edu.hw10.task2;

import java.lang.reflect.Proxy;
import java.nio.file.Path;

public class CacheProxy {
    private CacheProxy() {

    }

    public static Object create(Object obj, Class<?> target, Path path) {
        return Proxy.newProxyInstance(
            target.getClassLoader(),
            target.getInterfaces(),
            new CacheHandler(obj, path)
        );
    }
}
