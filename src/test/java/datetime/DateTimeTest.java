package datetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeTest {

    public static void main(String[] args) {

        LocalDateTime currentTime = LocalDateTime.now();
        currentTime = currentTime.plusDays(2);
        LocalDateTime endDate = endDate(currentTime);
        LocalDateTime startDate = startDate(endDate);

        System.out.println(startDate);
        System.out.println(endDate);

    }

    public static LocalDateTime startDate(LocalDateTime toLocalDateTime) {
        int addedDays = 0;
        while (addedDays < 5) {

            if (!(toLocalDateTime.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    toLocalDateTime.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
            toLocalDateTime = toLocalDateTime.minusDays(1);
        }
        toLocalDateTime = toLocalDateTime.plusDays(1);
        toLocalDateTime = toLocalDateTime.with(LocalTime.MIN);

        return toLocalDateTime;
    }

    public static LocalDateTime endDate(LocalDateTime current) {
        long minusDays = 0;
        if (current.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            minusDays = 1;
        }
        if (current.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            minusDays = 2;
        }
        LocalDateTime minus1Days = current.minusDays(minusDays);
        minus1Days = minus1Days.with(LocalTime.MAX);
        return minus1Days;
    }
}
