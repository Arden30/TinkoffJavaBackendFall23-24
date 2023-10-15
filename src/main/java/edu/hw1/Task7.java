package edu.hw1;


public class Task7 {

    private Task7() {

    }

    public static int rotateLeft(int num, int sh) {
        String[] res = Integer.toBinaryString(num).split("");
        int shift = sh % res.length;
        for (int right = res.length - 1, left = shift - 1, cnt = res.length - 2;
             left >= 0; left--) {

            //передвигаем в начало (друг за другом) цифры (на каждой итерации цикла),
            //которые должны оказаться на своих местах после циклического сдвига
            String tmp1 = res[right];
            res[right--] = res[left];

            //делаем сдвиг влево всех значений после цифры, записанной к началу
            while (right >= left) {
                String tmp2 = res[right];
                res[right--] = tmp1;
                tmp1 = tmp2;
            }
            right = cnt--;
        }
        return Integer.valueOf(String.join("", res), 2);
    }

    public static int rotateRight(int n, int sh) {
        String[] res = Integer.toBinaryString(n).split("");
        int shift = sh % res.length;
        for (int right = res.length - shift, left = 0, cnt = 0;
             right < res.length; right++) {
            String tmp1 = res[left];
            res[left++] = res[right];
            while (left <= right) {
                String tmp2 = res[left];
                res[left++] = tmp1;
                tmp1 = tmp2;
            }
            left = ++cnt;
        }
        return Integer.valueOf(String.join("", res), 2);
    }
}
