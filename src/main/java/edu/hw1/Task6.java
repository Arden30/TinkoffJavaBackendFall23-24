package edu.hw1;

import java.util.Arrays;

public class Task6 {

    private Task6() {
    }

    private static int cnt = 0;
    private final static int KAPREKAR = 6174;

    public static int k(int n) {
        // в случае одинаковых цифр в числе вернем -1
        if (increase(n) == decrease(n)) {
            return -1;
        }
        if (n == KAPREKAR) {
            int res = cnt;
            cnt = 0;
            return res;
        } else {
            cnt++;
            return k(decrease(n) - increase(n));
        }
    }

    public static int increase(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        Arrays.sort(arr);
        String res = "";
        for (char x : arr) {
            res += x;
        }
        return Integer.parseInt(res);
    }

    public static int decrease(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        Arrays.sort(arr);
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[i];
        }
        return Integer.parseInt(res);
    }
}
