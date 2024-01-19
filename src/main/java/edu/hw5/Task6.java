package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    private Task6() {

    }

    public static boolean subsequence(String string, String subsequence) {
        Pattern pattern = Pattern.compile("[^" + subsequence + "]");
        Matcher matcher = pattern.matcher(string);

        String seq = matcher.replaceAll("");
        Pattern subseq = Pattern.compile(subsequence);
        Matcher res = subseq.matcher(seq);

        return res.find();
    }
}
