package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private static final Feline FELINE = new Feline();

    private String sex;
    private Boolean hasMane;
    private Class<? extends Exception> expectedException;

    public LionParametrizedTest(String sex, Boolean hasMane, Class<? extends Exception> expectedException) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection testParameters() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, null},
                {"Самка", false, null},
                {"Трансгендер", null, Exception.class},
        });
    }

    @Test
    public void testInstantiateLion() {
        if(expectedException != null) {
            assertThrows(expectedException, () -> new Lion(sex, FELINE));
        } else {
            try {
                Lion lion = new Lion(sex, FELINE);
                assertEquals(hasMane, lion.doesHaveMane());
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }
}