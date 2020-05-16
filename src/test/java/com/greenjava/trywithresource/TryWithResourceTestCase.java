package com.greenjava.trywithresource;

import com.greenjava.sync.SynchMethod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TryWithResourceTestCase {


    private TryWithResource tryWithResource = null;
    private SynchMethod synchMethod = null;

    @Before
    public void before() {
        tryWithResource = new TryWithResource();
        synchMethod = new SynchMethod();
    }

    @Test
    public void tryWithResource1() {
        tryWithResource.tryWithResource();
        //tryWithResource.tryWithResourceWithMultipleResource();
    }

    @Test
    public void syncMethods() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(synchMethod::calculate));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);;
        Assert.assertEquals(1000,synchMethod.getSum());
    }
    @Test
    public void synchronusMethods() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000)
                .forEach(count -> executorService.submit(synchMethod::syncCalculate));
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);;
        Assert.assertEquals(1000,synchMethod.getSum());
    }
    @Test
    public void checkInstace() {
       //  Assert.assertThat(new UserData()).isInstanceOf(Object.class);
    }

}
