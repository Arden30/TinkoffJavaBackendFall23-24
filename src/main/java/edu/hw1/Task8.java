package edu.hw1;

public class Task8 {

    private Task8() {

    }

    private final static int[][] COMBINATIONS =
        {{1, -2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}};

    public static boolean knightBoardCapture(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    for (int[] combination : COMBINATIONS) {
                        if ((i + combination[0] < arr.length - 1 && i + combination[0] >= 0)
                            && (j + combination[1] < arr[i].length - 1 && j + combination[1] >= 0)
                            && arr[i][j] == arr[i + combination[0]][j + combination[1]]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
