package edu.hw1;

public class Task2 {

    private Task2() {

    }

    private final static int DIVIDER = 10;

    public static int countDigits(int num) {
        int x = num;
        int cnt = 0;
        while (x != 0) {
            x /= DIVIDER;
            cnt++;
        }
        return cnt == 0 ? 1 : cnt;
    }
}
