package edu.hw1;

public class Task8 {

    private Task8() {

    }

    @SuppressWarnings({"CyclomaticComplexity", "ReturnCount"})
    public static boolean knightBoardCapture(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    if (i + 1 <= arr.length - 1 && j - 2 >= 0 && arr[i][j] == arr[i + 1][j - 2]) {
                        return false;
                    } else if (i + 1 <= arr.length - 1 && j + 2 <= arr[i].length - 1
                        && arr[i][j] == arr[i + 1][j + 2]) {
                        return false;
                    } else if (i + 2 <= arr.length - 1 && j - 1 >= 0 && arr[i][j] == arr[i + 2][j - 1]) {
                        return false;
                    } else if (i + 2 <= arr.length - 1 && j + 1 <= arr[i].length - 1
                        && arr[i][j] == arr[i + 2][j + 1]) {
                        return false;
                    } else if (i - 1 >= 0 && j + 2 <= arr[i].length - 1
                        && arr[i][j] == arr[i - 1][j + 2]) {
                        return false;
                    } else if (i - 1 >= 0 && j - 2 >= 0 && arr[i][j] == arr[i - 1][j - 2]) {
                        return false;
                    } else if (i - 2 >= 0 && j - 1 >= 0 && arr[i][j] == arr[i - 2][j - 1]) {
                        return false;
                    } else if (i - 2 >= 0 && j + 1 <= arr[i].length - 1
                        && arr[i][j] == arr[i - 2][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
