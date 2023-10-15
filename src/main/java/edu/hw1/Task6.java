package edu.hw1;

import java.util.Arrays;
import java.util.Collections;

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
        String[] arr = Integer.toString(n).split("");
        Arrays.sort(arr);
        StringBuilder res = new StringBuilder();
        for (String x : arr) {
            res.append(x);
        }
        return Integer.parseInt(res.toString());
    }

    public static int decrease(int n) {
        String[] arr = Integer.toString(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder res = new StringBuilder();
        for (String x : arr) {
            res.append(x);
        }
        return Integer.parseInt(res.toString());
    }
}
