package edu.hw3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Task4 {
    private Task4() {

    }

    private static final Map<Integer, String> NUMBERS_DICT = new TreeMap<>(Comparator.reverseOrder());
    private static final int LIMIT = 4000;

    @SuppressWarnings("MagicNumber")
    private static void romanNumbersDict() {
        NUMBERS_DICT.put(1000, "M");
        NUMBERS_DICT.put(900, "CM");
        NUMBERS_DICT.put(500, "D");
        NUMBERS_DICT.put(400, "CD");
        NUMBERS_DICT.put(100, "C");
        NUMBERS_DICT.put(90, "XC");
        NUMBERS_DICT.put(50, "L");
        NUMBERS_DICT.put(40, "XL");
        NUMBERS_DICT.put(10, "X");
        NUMBERS_DICT.put(9, "IX");
        NUMBERS_DICT.put(5, "V");
        NUMBERS_DICT.put(4, "IV");
        NUMBERS_DICT.put(1, "I");
    }

    private static StringBuilder checkInput(int num) {
        if (num <= 0) {
            return new StringBuilder("Number must be positive");
        } else if (num >= LIMIT) {
            return new StringBuilder("Numbers larger than 3999 can't be written with classical roman numbers");
        }
        return new StringBuilder();
    }

    public static String convertToRoman(int inp) {
        try {
            int num = inp;
            romanNumbersDict();
            StringBuilder res = checkInput(num);
            if (!res.isEmpty()) {
                return res.toString();
            }
            while (num != 0) {
                for (var pair : NUMBERS_DICT.entrySet()) {
                    if (num >= pair.getKey()) {
                        res.append(pair.getValue());
                        num -= pair.getKey();
                        break;
                    }
                }
            }
            return res.toString();
        } catch (NumberFormatException e) {
            return "Input number!";
        }
    }

}
