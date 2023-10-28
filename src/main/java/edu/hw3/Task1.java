package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    private Task1() {
    }

    private static final Map<Character, Character> CHARS = new HashMap<>();
    private static final int LEN = 26;

    public static void fillChars() {
        for (int i = 0; i < LEN; i++) {
            CHARS.put(Character.toChars('A' + i)[0], Character.toChars('Z' - i)[0]);
        }
        for (int i = 0; i < LEN; i++) {
            CHARS.put(Character.toChars('a' + i)[0], Character.toChars('z' - i)[0]);
        }
    }

    public static String atbash(String str) {
        if (str == null) {
            return null;
        }
        fillChars();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (CHARS.containsKey(str.charAt(i))) {
                res.append(CHARS.get((str.charAt(i))));
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
