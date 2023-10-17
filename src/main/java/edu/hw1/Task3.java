package edu.hw1;

import java.util.Arrays;

public class Task3 {

    private Task3() {

    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        return !(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0)
            && (Arrays.stream(arr1).min().getAsInt() > Arrays.stream(arr2).min().getAsInt()
            && Arrays.stream(arr1).max().getAsInt() < Arrays.stream(arr2).max().getAsInt());
    }
}
