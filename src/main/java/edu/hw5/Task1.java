package edu.hw5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Task1 {
    private Task1() {

    }

    public static String avgTime(String[] str) {
        try {
            long minutesSum = 0;

            for (String s : str) {
                String[] time = s.split(" - ");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd, hh:mm");

                Date from = simpleDateFormat.parse(time[0]);
                Date to = simpleDateFormat.parse(time[1]);

                Duration duration = Duration.between(from.toInstant(), to.toInstant());

                long minutes = duration.toMinutes();
                minutesSum += minutes;
            }

            long avg = minutesSum / str.length;
            Date date = new SimpleDateFormat("m").parse(Long.toString(avg));
            DateFormat dateFormat = new SimpleDateFormat("hч mmм");

            return dateFormat.format(date);

        } catch (ParseException e) {
            throw new IllegalArgumentException("Wrong input, can't be formatted to valid data");
        }

    }
}
