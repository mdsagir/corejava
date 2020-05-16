package com.greenjava.trywithresource;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Logger;

/*
Java have provide two decimal number float and double, double is default
 */
public class _DecimalFormat {

    Logger logger = Logger.getLogger(_DecimalFormat.class.getName());

    @Test
    public void decimalFormat() {
        double PI = 3.1415;
        logger.info("PI " + PI);
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        logger.info("Decimal format " + decimalFormat.format(PI));



        double round = round(PI, 2);
        logger.info("Round "+round);
    }

    private static double round(double value, int place) {
        if (place<0) throw new  IllegalArgumentException();
        BigDecimal bigDecimal=new BigDecimal(Double.toString(value));
        bigDecimal=bigDecimal.setScale(place, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
