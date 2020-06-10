package com.greenjava.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class UseLocalDate {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        LocalDate localDateFactoryMethod = LocalDate.of(2020, 1, 16);
        System.out.println(localDateFactoryMethod);

        LocalDate localDateFactoryParse = LocalDate.parse("2020-01-16");
        System.out.println(localDateFactoryParse);

        System.out.println("======DAYS========");

        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        System.out.println("DAY OF WEEK: "+dayOfWeek); // SUNDAY

        int dayOfMonth = currentDate.getDayOfMonth();
        System.out.println("DAY OF MONTH: "+dayOfMonth); // 17

        int dayOfYear = currentDate.getDayOfYear();
        System.out.println("DAY OF YEAR: "+dayOfYear);

        LocalDate nextDays = currentDate.plusDays(1);
        System.out.println("NEXT DAYS  : "+nextDays);

        LocalDate nextDay = currentDate.plus(1, ChronoUnit.DAYS);
        System.out.println("NEXT DAYS  : "+nextDay);

        LocalDate firstDaysOfMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("FIRST DAY OF MONTHS : "+firstDaysOfMonth);

        LocalDate lastDayOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("LAST DAY OF MONTHS : "+lastDayOfMonth);

        LocalDate firstDaysOfNextMonth = currentDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("FIRST DAY OF NEXT MONTHS : "+firstDaysOfNextMonth);

        LocalDate lastDayOfYear = currentDate.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("LAST DAY OF YEAR : "+lastDayOfYear);


        LocalDate firstDayOfNextYear = currentDate.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("FIRST DAY OF NEXT YEAR : "+firstDayOfNextYear);

        LocalDate nextDayOfWeek = currentDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)); // excludes SUNDAY
        System.out.println("NEXT DAY OF WEEK : "+nextDayOfWeek);

        LocalDate nextDayOfWeekSame = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)); // includes SUNDAY
        System.out.println("NEXT DAY OF WEEK SAME : "+nextDayOfWeekSame);

        LocalDate dayOfWeekInMonth = currentDate.with(TemporalAdjusters.dayOfWeekInMonth(7, DayOfWeek.FRIDAY)); // 7th friday of day
        System.out.println("DAY OF WEEK IN NEXT MONTH : "+dayOfWeekInMonth);


        LocalDate firstInMonth = currentDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // fist Monday in Month
        System.out.println("FIRST IN MONTH : "+firstInMonth);

        LocalDate lastInMonth = currentDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("LAST IN MONTH : "+lastInMonth);

        LocalDate previousDayOfWeek = currentDate.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        System.out.println("PREVIOUS DAY OF WEEK : "+previousDayOfWeek);

        LocalDate nextOneMonth = currentDate.with(TemporalAdjusters.ofDateAdjuster(date -> date.plusMonths(1)));
        System.out.println("OF DATE ADJUSTER : "+nextOneMonth);

        LocalDate alignDayOfWeek = currentDate.with(ChronoField.DAY_OF_WEEK, 7);
        System.out.println("ALIGN DAY OF WEEK : "+alignDayOfWeek);

        System.out.println("======DAYS========");


        /*LocalDate nextDay = currentDate.plusDays(1);
        System.out.println(nextDay);

        LocalDate prevDate = currentDate.minusDays(1);
        System.out.println(prevDate);

        LocalDate prevDate2 = currentDate.minus(1, ChronoUnit.DAYS);
        System.out.println(prevDate2);

        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        System.out.println(dayOfWeek);

        int dayOfMonth = currentDate.getDayOfMonth();
        System.out.println(dayOfMonth);

        int year = currentDate.getYear();
        System.out.println(year);

        IsoChronology chronology = currentDate.getChronology();
        System.out.println(chronology);

        IsoEra era = currentDate.getEra();
        System.out.println(era);

        Month month = currentDate.getMonth();
        System.out.println(month);

        DayOfWeek dayOfWeek1 = currentDate.getDayOfWeek();
        System.out.println(dayOfWeek1);*/
        /*LocalDate with = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);*/
    }
}
