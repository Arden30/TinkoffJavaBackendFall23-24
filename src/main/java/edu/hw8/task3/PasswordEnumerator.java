package edu.hw8.task3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PasswordEnumerator {
    private final PasswordDB passwordDB;
    private final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
    private final int passwordLen;
    private final Map<String, String> encrypted = new HashMap<>();

    private final static int RADIX = 16;
    private final static int MAX_LEN = 32;

    public PasswordEnumerator(PasswordDB passwordDB, int passwordLen) {
        this.passwordDB = passwordDB;
        this.passwordLen = passwordLen;
    }

    public Map<String, String> nextPasswordSingleThread() {
        Map<String, String> passwords = passwordDB.getDB();

        for (int len = 1; len <= passwordLen; len++) {
            List<String> generatedPass = generatePasswords(len);

            for (String password : generatedPass) {
                String hash = encryptPassword(password);

                if (passwords.containsKey(hash)) {
                    encrypted.put(password, passwords.get(hash));
                    passwords.remove(hash);
                }
            }
        }

        return encrypted;
    }

    public Map<String, String> nextPasswordMultithreading(int numberOfThreads) {
        Map<String, String> passwords = passwordDB.getDB();

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int len = 1; len <= passwordLen; len++) {
            List<String> generatedPass = generatePasswordsMultithreading(len, executorService);

            for (String password : generatedPass) {
                String hash = encryptPassword(password);
                if (passwords.containsKey(hash)) {
                    encrypted.put(password, passwords.get(hash));
                    passwords.remove(hash);
                }
            }
        }

        executorService.shutdown();
        return encrypted;
    }

    private List<String> generatePasswordsMultithreading(int len, ExecutorService executorService) {
        List<String> passwords =
            new CopyOnWriteArrayList<>(); // Используем CopyOnWriteArrayList для безопасности в многопоточной среде

        List<Callable<Void>> tasks = new ArrayList<>();
        int chunkSize = alphabet.length() / len;

        for (int i = 0; i < len; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == len - 1) ? alphabet.length() : (i + 1) * chunkSize;

            final String subAlphabet = alphabet.substring(startIndex, endIndex);

            tasks.add(() -> {
                generatePasswordsHelper(subAlphabet, len, "", passwords);
                return null;
            });
        }

        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        return passwords;
    }

    public List<String> generatePasswords(int len) {
        List<String> passwords = new ArrayList<>();

        generatePasswordsHelper(alphabet, len, "", passwords);

        return passwords;
    }

    private void generatePasswordsHelper(String alphabet, int len, String current, List<String> passwords) {
        if (len == 0) {
            passwords.add(current);
            return;
        }

        for (int i = 0; i < alphabet.length(); i++) {
            char currentChar = alphabet.charAt(i);
            generatePasswordsHelper(alphabet, len - 1, currentChar + current, passwords);
        }
    }

    public String encryptPassword(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hashText = new StringBuilder(no.toString(RADIX));
            while (hashText.length() < MAX_LEN) {
                hashText.insert(0, "0");
            }
            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
