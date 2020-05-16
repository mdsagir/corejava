package com.greenjava.trywithresource;

import com.greenjava.lambda.LambadaIteration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LambdaIterationTest {

    LambadaIteration lambadaIteration = null;

    @Before
    public void init() {
        lambadaIteration = new LambadaIteration();
    }

    @Test
    public void iterationTest() {

        double highScoreActual = lambadaIteration.iteration();

        Assert.assertEquals(90.0, highScoreActual, 0);
    }

    @Test
    public void moreFunctionTest() {
        double actualHighScore = lambadaIteration.moreFunctional();
        Assert.assertEquals(92.0, actualHighScore, 0);
    }

    @Test
    public void lambdaTest() {
        double actualHighScore = lambadaIteration.lambdaExpression();
        Assert.assertEquals(90.0,actualHighScore,0);
    }
}
