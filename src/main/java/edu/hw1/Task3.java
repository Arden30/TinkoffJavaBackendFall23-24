package edu.hw1;

public class Task3 {

    private Task3() {

    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        return !(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0)
            && (findMin(arr1) > findMin(arr2) && findMax(arr1) < findMax(arr2));
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int x : arr) {
            min = Math.min(x, min);
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            max = Math.max(x, max);
        }
        return max;
    }
}
