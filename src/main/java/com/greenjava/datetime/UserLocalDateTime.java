package com.greenjava.datetime;

import java.time.*;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Locale;

public class UserLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime currentLocalDateTime = LocalDateTime.now();

        DayOfWeek dayOfWeek = currentLocalDateTime.getDayOfWeek();
        System.out.println("DAY OF WEEK : "+dayOfWeek); // MONDAY

        int monthValue = currentLocalDateTime.getMonthValue();
        System.out.println("MONTH IN VALUE : "+monthValue); // 1

        Month month = currentLocalDateTime.getMonth();
        System.out.println("NAME OF MONTH : "+month); //JANUARY

        int year = currentLocalDateTime.getYear();
        System.out.println("YEAR "+year);

        int dayOfMonth = currentLocalDateTime.getDayOfMonth();
        System.out.println("DAY OF MONTH : "+dayOfMonth);

        int dayOfYear = currentLocalDateTime.getDayOfYear();
        System.out.println("DAY OF YEAR : "+dayOfYear);

        int hour = currentLocalDateTime.getHour();
        System.out.println("HOUR : "+hour);

        int minute = currentLocalDateTime.getMinute();
        System.out.println("MINUTES : "+minute);

        int second = currentLocalDateTime.getSecond();
        System.out.println("SECOND : "+second);

        int nano = currentLocalDateTime.getNano();
        System.out.println("NANO : "+nano);

        Chronology chronology = currentLocalDateTime.getChronology();

        String dateFormat = chronology.getId();
        System.out.println("DATE FORMAT : "+dateFormat);

        String calendarType = chronology.getCalendarType();
        System.out.println("CALENDER TYPE : "+calendarType);

        LocalDateTime endOfDate = currentLocalDateTime.with(ChronoField.NANO_OF_DAY, LocalTime.MAX.toNanoOfDay());
        System.out.println("EOD : "+endOfDate);

        LocalDateTime endOfDates = currentLocalDateTime.toLocalDate().atTime(LocalTime.MAX);
        System.out.println("EOD : "+endOfDates);

        String format = currentLocalDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(Locale.getDefault()));
        System.out.println("FORMAT "+format);

        LocalDateTime plusTwoDays = currentLocalDateTime.plusDays(2);

        Duration between = Duration.between(currentLocalDateTime, plusTwoDays);

    }
}
