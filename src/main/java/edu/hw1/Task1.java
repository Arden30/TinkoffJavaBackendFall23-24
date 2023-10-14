package edu.hw1;

public class Task1 {

    private Task1() {

    }

    private final static int ONE_MINUTE_IN_SECONDS = 60;

    public static int minutesToSeconds(String str) {
        String[] tmp = str.split(":");
        int minutes = Integer.parseInt(tmp[0]);
        int seconds = Integer.parseInt(tmp[1]);
        if (seconds < ONE_MINUTE_IN_SECONDS && minutes >= 0 && seconds >= 0) {
            return minutes * ONE_MINUTE_IN_SECONDS + seconds;
        }
        return -1;
    }
}
