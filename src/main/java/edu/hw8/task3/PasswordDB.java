package edu.hw8.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class PasswordDB {
    private final Map<String, String> passwords = new HashMap<>();
    private final Path path;

    public PasswordDB(String file) {
        this.path = Path.of(file);
        fillDB();
    }

    private void fillDB() {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] line = str.split("\\s+");
                passwords.put(line[1], line[0]);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public Map<String, String> getDB() {
        return passwords;
    }
}
