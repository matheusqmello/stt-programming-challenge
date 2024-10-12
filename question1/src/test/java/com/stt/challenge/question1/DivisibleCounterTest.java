package com.stt.challenge.question1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DivisibleCounterTest {

    private DivisibleCounter counterUnderTest;
    private int numberToTest;
    private boolean isDivisible;
    private boolean isNotZero;

    @Before
    public void setUp() throws Exception {
        counterUnderTest = Mockito.spy(DivisibleCounter.class);
    }

    // Counter core
    @Test
    public void testCount_whenUpTo3_printsA() {
        counterUnderTest.countDivisibles(3);

        // Verifies if "log()" was called once with "A" parameter.
        Mockito.verify(counterUnderTest, Mockito.times(1)).log("A");
    }

    @Test
    public void testCount_whenUpTo5_printsAandB() {
        counterUnderTest.countDivisibles(5);

        Mockito.verify(counterUnderTest, Mockito.times(1)).log("A");

        Mockito.verify(counterUnderTest, Mockito.times(1)).log("B");
    }

    @Test
    public void testCount_whenUpTo10_printsAandB() {
        counterUnderTest.countDivisibles(10);

        Mockito.verify(counterUnderTest, Mockito.times(3)).log("A");

        Mockito.verify(counterUnderTest, Mockito.times(2)).log("B");
    }

    @Test
    public void testCount_whenUpTo15_printsABandC() {
        counterUnderTest.countDivisibles(15);

        Mockito.verify(counterUnderTest, Mockito.times(4)).log("A");

        Mockito.verify(counterUnderTest, Mockito.times(2)).log("B");

        Mockito.verify(counterUnderTest, Mockito.times(1)).log("C");
    }

    @Test
    public void testCount_whenUpTo20_printsABandC() {
        counterUnderTest.countDivisibles(20);

        Mockito.verify(counterUnderTest, Mockito.times(5)).log("A");

        Mockito.verify(counterUnderTest, Mockito.times(3)).log("B");

        Mockito.verify(counterUnderTest, Mockito.times(1)).log("C");
    }

    // Divisible by 3
    @Test
    public void testIsDivBy3_when0_returnsFalse() {
        numberToTest = 0;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertFalse(isDivisible);
    }

    @Test
    public void testIsDivBy3_whenDivisibleBy3_returnsTrue() {
        numberToTest = 3;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertTrue(isDivisible);

        numberToTest = 15;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertTrue(isDivisible);

        numberToTest = 18;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertTrue(isDivisible);
    }

    @Test
    public void testIsDivBy3_whenNotDivisibleBy3_returnsFalse() {
        numberToTest = 5;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertFalse(isDivisible);

        numberToTest = 10;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertFalse(isDivisible);

        numberToTest = 20;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertFalse(isDivisible);
    }

    @Test
    public void testIsDivBy3_whenNegativeDivisibleBy3_returnsTrue() {
        numberToTest = -3;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertTrue(isDivisible);

        numberToTest = -18;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertTrue(isDivisible);
    }

    @Test
    public void testIsDivBy3_whenNegativeNotDivisibleBy3_returnsFalse() {
        numberToTest = -5;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertFalse(isDivisible);

        numberToTest = -20;
        isDivisible = counterUnderTest.isDivBy3(numberToTest);
        Assert.assertFalse(isDivisible);
    }

    // Divisible by 5
    @Test
    public void testIsDivBy5_when0_returnsFalse() {
        numberToTest = 0;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertFalse(isDivisible);
    }

    @Test
    public void testIsDivBy5_whenDivisibleBy5_returnsTrue() {
        numberToTest = 5;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertTrue(isDivisible);

        numberToTest = 15;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertTrue(isDivisible);

        numberToTest = 20;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertTrue(isDivisible);
    }

    @Test
    public void testIsDivBy5_whenNotDivisibleBy5_returnsFalse() {
        numberToTest = 3;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertFalse(isDivisible);

        numberToTest = 18;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertFalse(isDivisible);
    }

    @Test
    public void testIsDivBy5_whenNegativeDivisibleBy5_returnsTrue() {
        numberToTest = -5;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertTrue(isDivisible);

        numberToTest = -20;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertTrue(isDivisible);
    }

    @Test
    public void testIsDivBy5_whenNegativeNotDivisibleBy5_returnsFalse() {
        numberToTest = -3;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertFalse(isDivisible);

        numberToTest = -16;
        isDivisible = counterUnderTest.isDivBy5(numberToTest);
        Assert.assertFalse(isDivisible);
    }

    // Divisible by 3 and 5
    @Test
    public void testIsDivBy3And5_whenDivisibleBy3And5_returnsTrue() {
        numberToTest = 15;
        isDivisible = counterUnderTest.isDivBy3And5(numberToTest);
        Assert.assertTrue(isDivisible);
    }

    @Test
    public void testIsDivBy3And5_whenNotDivisibleBy3And5_returnsFalse() {
        numberToTest = 3;
        isDivisible = counterUnderTest.isDivBy3And5(numberToTest);
        Assert.assertFalse(isDivisible);

        numberToTest = 5;
        isDivisible = counterUnderTest.isDivBy3And5(numberToTest);
        Assert.assertFalse(isDivisible);
    }

    // Is Not Zero
    @Test
    public void testIsNotZero_when0_returnsFalse() {
        numberToTest = 0;
        isNotZero = counterUnderTest.isNotZero(numberToTest);
        Assert.assertFalse(isNotZero);
    }

    @Test
    public void testIsNotZero_whenNot0_returnsTrue() {
        numberToTest = 1;
        isNotZero = counterUnderTest.isNotZero(numberToTest);
        Assert.assertTrue(isNotZero);

        numberToTest = -1;
        isNotZero = counterUnderTest.isNotZero(numberToTest);
        Assert.assertTrue(isNotZero);
    }

}
