package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {
    private Task8() {

    }

    public static boolean oddLength(String string) {
        Pattern pattern = Pattern.compile("^([01]{2})*[01]$");
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    public static boolean oddZeroOrEvenOne(String string) {
        Pattern pattern = Pattern.compile("(^0([01]{2})*$)|(^1([01]{2})*[01]$)");
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    public static boolean zeroesMultipleOfThree(String string) {
        Pattern pattern = Pattern.compile("^(?:(?:1*0){3})*1*$");
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    public static boolean allExcept11Or111(String string) {
        Pattern pattern = Pattern.compile("^(?!(11$)|(111$))[01]*$");
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    public static boolean everyThirdIsOne(String string) {
        Pattern pattern = Pattern.compile("^(?:1[01])*1?$");
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }
}
