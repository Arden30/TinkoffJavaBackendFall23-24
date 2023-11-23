package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {

    }

    private final static int THIRTEEN = 13;

    public static List<LocalDate> thirteenthFridays(int year) {
        List<LocalDate> res = new ArrayList<>();
        LocalDate date = LocalDate.of(year, Month.JANUARY, THIRTEEN);

        while (date.getYear() == year) {
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                res.add(date);
            }
            date = date.plusMonths(1);
        }

        return res;
    }

    public static LocalDate nextThirteenthFriday(LocalDate date) {
        TemporalAdjuster adjuster = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        LocalDate nextFriday = date.with(adjuster);

        while (nextFriday.getDayOfMonth() != THIRTEEN) {
            nextFriday = nextFriday.with(adjuster);
        }

        return nextFriday;
    }
}
