package edu.hw1;

public class Task4 {

    private Task4() {

    }

    public static String fixString(String str) {
        String res = "";
        if (str == null) {
            return null;
        }
        int len = str.length();
        for (int i = 0; i < len; i += 2) {
            //проверка сделана для нечетного числа символов
            //(чтобы при достижении последнего символа он одиночным образом добавлялся к строке)
            if (i + 1 != len) {
                res = res + str.charAt(i + 1) + str.charAt(i);
            } else {
                res += str.charAt(i);
            }
        }
        return res;
    }
}
