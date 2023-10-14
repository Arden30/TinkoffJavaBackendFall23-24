package edu.hw1;

public class Task7 {

    private Task7() {

    }

    private final static int DIVIDER = 10;

    public static int[] toIntArray(int num) {
        int n = num;
        int len = Integer.toString(n).length();
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            res[i] = n % DIVIDER;
            n /= DIVIDER;
        }
        return res;
    }

    public static int toIntNum(int[] res) {
        int num = 0;
        for (int i = 0; i < res.length; i++) {
            num += res[i] * (int) Math.pow(DIVIDER, res.length - 1 - i);
        }
        return num;
    }

    public static int toBinary(int num) {
        int n = num;
        String res = "";
        if (n == 0) {
            return 0;
        }
        while (n >= 1) {
            res = (n % 2) + res;
            n /= 2;
        }
        return Integer.parseInt(res);
    }

    public static int toDecimal(int num) {
        int n = num;
        int res = 0;
        int len = Integer.toString(n).length();
        for (int i = 0; i < len; i++) {
            res += (n % DIVIDER) * Math.pow(2, i);
            n /= DIVIDER;
        }
        return res;
    }

    public static int rotateLeft(int num, int sh) {
        int[] res = toIntArray(toBinary(num));
        int shift = sh % res.length;
        for (int right = res.length - 1, left = shift - 1, cnt = res.length - 2;
             left >= 0; left--) {

            //передвигаем в начало (друг за другом) цифры (на каждой итерации цикла),
            // которые должны оказаться на своих местах после циклического сдвига
            int tmp1 = res[right];
            res[right--] = res[left];

            //делаем сдвиг влево всех значений после цифры, записанной к началу
            while (right >= left) {
                int tmp2 = res[right];
                res[right--] = tmp1;
                tmp1 = tmp2;
            }
            right = cnt--;
        }
        return toDecimal(toIntNum(res));
    }

    public static int rotateRight(int n, int sh) {
        int[] res = toIntArray(toBinary(n));
        int shift = sh % res.length;
        for (int right = res.length - shift, left = 0, cnt = 0;
             right < res.length; right++) {
            int tmp1 = res[left];
            res[left++] = res[right];
            while (left <= right) {
                int tmp2 = res[left];
                res[left++] = tmp1;
                tmp1 = tmp2;
            }
            left = ++cnt;
        }
        return toDecimal(toIntNum(res));
    }
}
