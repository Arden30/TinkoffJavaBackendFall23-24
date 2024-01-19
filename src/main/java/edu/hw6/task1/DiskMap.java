package edu.hw6.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final Map<String, String> disk = new HashMap<>();
    private final Path path;

    public DiskMap(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public void saveToFile() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Map.Entry<String, String> entry : disk.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        }
    }

    public void downloadFromFile() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            disk.clear();
            String str;
            while ((str = reader.readLine()) != null) {
                String[] arr = str.split(":");
                if (arr.length != 2) {
                    throw new IOException("Incorrect line from the file (must match pattern key:value)");
                }
                disk.put(arr[0], arr[1]);
            }
        }
    }

    @Override
    public int size() {
        return disk.size();
    }

    @Override
    public boolean isEmpty() {
        return disk.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return disk.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return disk.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return disk.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        return disk.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return disk.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        disk.putAll(m);
    }

    @Override
    public void clear() {
        disk.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return disk.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return disk.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return disk.entrySet();
    }
}
