package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    public static List<String> clusterize(String inp) {
        List<String> res = new ArrayList<>();

        //ignore chars that differ from brackets
        String str = inp.replaceAll("[^()]", "");

        for (int i = 0; i < str.length();) {
            int openBrackets = 0;
            int closeBrackets = 0;
            StringBuilder cluster = new StringBuilder();
            while (openBrackets == 0 || openBrackets != closeBrackets) {
                if (str.charAt(i) == '(') {
                    openBrackets++;
                    cluster.append('(');
                } else if (str.charAt(i) == ')' && closeBrackets < openBrackets) {
                    closeBrackets++;
                    cluster.append(')');
                } else {
                    return null;
                }
                i++;
            }
            res.add(cluster.toString());
        }
        return res;
    }

}
