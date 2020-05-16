package com.greenjava.trywithresource;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
 Java 7 provide binary literals, Its simplify the binary number uses,
 we need to prefix 0B or 0b
 */
public class BinaryLiteralTest {

    @Test
    public void givenBinaryLiteralsReturnDecimalValue() {

        byte five = 0b101;
        Assert.assertEquals((byte) 5, five);

        short three = 0b11;
        Assert.assertEquals(3, three);

        int nine = 0b1001;
        Assert.assertEquals(9, nine);

        long twentyNine = 0b11101;
        Assert.assertEquals(29, twentyNine);

        int minusThirtySeven = -0b100101;
        Assert.assertEquals(-37, minusThirtySeven);

    }

    @Test
    public void decimalToBinary() throws FileNotFoundException {
        String s = Integer.toBinaryString(8);
        int b=Integer.parseInt(s);
        System.setOut(new PrintStream(new File("hello.txt")));
        System.out.println(b);
        Assert.assertEquals("1000", Integer.toBinaryString(8));
        Assert.assertEquals("10100", Integer.toBinaryString(20));
    }
}
