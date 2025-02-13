package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private static final Feline FELINE = new Feline();

    private String sex;
    private Class<? extends Exception> expectedException;

    public LionParametrizedTest(String sex, Class<? extends Exception> expectedException) {
        this.sex = sex;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection testParameters() {
        return Arrays.asList(new Object[][]{
                {"Самец", null},
                {"Самка", null},
                {"Трансгендер", Exception.class},
        });
    }

    @Test
    public void testInstantiateLion() {
        if(expectedException != null) {
            assertThrows(expectedException, () -> new Lion(sex, FELINE));
        } else {
            try {
                new Lion(sex, FELINE);
            } catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }
}