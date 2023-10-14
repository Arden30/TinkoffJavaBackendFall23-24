package edu.hw1;

public class Task5 {

    private Task5() {

    }

    private final static int DIVIDER = 10;

    public static boolean isPalindromeDescendant(int x) {
        int num = x;
        String res = Integer.toString(num);
        if (res.length() == 1) {
            return true;
        }
        // если в числе нечетное количество цифр и при этом оно изначально не палиндром, то false
        if (res.length() % 2 != 0 && !palindrome(res)) {
            return false;
        }
        while (res.length() > 1) {
            if (palindrome(res)) {
                return true;
            }
            num = Integer.parseInt(res);
            res = "";
            while (num > 0) {
                int first = num % DIVIDER;
                num /= DIVIDER;
                int second = num % DIVIDER;
                num /= DIVIDER;
                res = (first + second) + res;
            }
        }
        return false;
    }

    public static boolean palindrome(String res) {
        for (int i = 0, j = res.length() - 1; i < res.length() / 2; i++, j--) {
            if (res.charAt(i) != res.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
