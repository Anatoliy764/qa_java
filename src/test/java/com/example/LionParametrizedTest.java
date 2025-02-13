package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private Feline feline;
    private String sex;
    private Boolean hasMane;
    private Class<? extends Exception> expectedException;

    public LionParametrizedTest(String sex, Feline feline, Boolean hasMane, Class<? extends Exception> expectedException) {
        this.sex = sex;
        this.feline = feline;
        this.hasMane = hasMane;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection testParameters() {
        Feline feline = new Feline();
        return Arrays.asList(new Object[][]{
                {"Самец", feline, true, null},
                {"Самка", feline, false, null},
                {"Трансгендер", feline, null, Exception.class},
                {"Самец", null, true, IllegalArgumentException.class},
        });
    }

    @Test
    public void testInstantiateLion() {
        if(expectedException != null) {
            Exception exception = assertThrows(expectedException, () -> new Lion(sex, feline));
            assertEquals(expectedException, exception.getClass());
        } else {
            try {
                Lion lion = new Lion(sex, feline);
                assertEquals(hasMane, lion.doesHaveMane());
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }
}