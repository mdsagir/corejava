package com.greenjava.trywithresource;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class EnumTest {

    Logger logger = Logger.getLogger(EnumTest.class.getName());

    public enum DayOfWeekEnum {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    public enum DayOfWeekStatus {
        SUNDAY("off"),
        MONDAY("working"),
        TUESDAY("working"),
        WEDNESDAY("working"),
        THURSDAY("working"),
        FRIDAY("working"),
        SATURDAY("off");

        public String typeOfDay;

        DayOfWeekStatus(String typeOfDay) {
            this.typeOfDay = typeOfDay;
        }

        public String getTypeOfDay() {
            return typeOfDay;
        }

        public void setTypeOfDay(String typeOfDay) {
            this.typeOfDay = typeOfDay;
        }

        public static Stream<DayOfWeekStatus> stream() {
            return Stream.of(DayOfWeekStatus.values());
        }
    }

    @Test
    public void enumTest() {

        // iterating by for each loop
        for (DayOfWeekEnum dayOfWeekEnum : DayOfWeekEnum.values()) {
            logger.info("Days " + dayOfWeekEnum);

        }

        // iterating using stream
        Stream<DayOfWeekEnum> daysStream = Stream.of(DayOfWeekEnum.values());
        daysStream.forEach(dayOfWeekEnum -> logger.info("By stream " + dayOfWeekEnum));

        List<DayOfWeekEnum> dayOfWeekEnums = Arrays.asList(DayOfWeekEnum.values());
        dayOfWeekEnums.forEach(dayOfWeekEnum -> logger.info("By List " + dayOfWeekEnum));

    }
    @Test
    public void enumDaysStatus() {

        Consumer<DayOfWeekStatus> dayOfWeekStatusConsumer= dayOfWeekStatus ->
                logger.info("status "+dayOfWeekStatus);

        DayOfWeekStatus.stream()
                .filter(dayOfWeekStatus -> dayOfWeekStatus.getTypeOfDay().equals("off"))
                .forEach(dayOfWeekStatus -> logger.info("status off day "+dayOfWeekStatus));

        EnumSet.allOf(DayOfWeekStatus.class)
                .forEach(dayOfWeekStatusConsumer);


    }
}
