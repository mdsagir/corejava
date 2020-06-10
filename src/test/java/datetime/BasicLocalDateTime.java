package datetime;


import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Log4j
public class BasicLocalDateTime {

    @Test
    public void basic_local_date_time() {
        // default date time format ISO yyyy-MM-dd

        LocalDate localDate = LocalDate.now();
        log.info("localDate      : " + localDate);
        LocalDate defineLocalDate = LocalDate.of(2020, 12, 12);
        LocalDate defineLocalDate1 = LocalDate.of(2020, Month.APRIL, 23);
        log.info("defineLocalDate: " + defineLocalDate);
        LocalDate parseLocalDate = LocalDate.parse("2020-12-12");
        log.info("parseLocalDate : " + parseLocalDate);

        log.info("=====LocalDateTime=======");
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("localDateTime  : "+localDateTime);
        LocalDateTime ofLocalDateTime = LocalDateTime.of(2020, Month.AUGUST, 23, 11, 23, 12, 343);
        log.info("localDateTime  : "+ofLocalDateTime);



    }

    @Test
    public void local_date_time_test() {

    }
}
