package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private static final Feline FELINE = new Feline();

    private int inputKittens;
    private int expectedKittens;
    private Class<? extends RuntimeException> expectedException;

    public FelineParametrizedTest(int inputKittens, int expectedKittens, Class<? extends RuntimeException> expectedException) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][] {
                { -1, -1, RuntimeException.class },
                { 0, 0, null },
                { 1, 1, null },
        });
    }

    @Test
    public void getKittens() {
        if(expectedException != null) {
            assertThrows(expectedException, () -> FELINE.getKittens(inputKittens));
        } else {
            assertEquals(expectedKittens, FELINE.getKittens(inputKittens));
        }
    }
}
