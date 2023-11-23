package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private Task5() {

    }

    public static boolean validateLicensePlateNumber(String license) {
        Pattern pattern = Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$");
        Matcher matcher = pattern.matcher(license);

        return matcher.find();
    }
}
