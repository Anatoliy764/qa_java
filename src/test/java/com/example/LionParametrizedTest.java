package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private Feline feline;
    private String sex;
    private Boolean expectedHasMane;
    private Class<? extends Exception> expectedException;

    public LionParametrizedTest(String sex, Feline feline, Boolean expectedHasMane, Class<? extends Exception> expectedException) {
        this.sex = sex;
        this.feline = feline;
        this.expectedHasMane = expectedHasMane;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection testParameters() {
        Feline feline = Mockito.mock(Feline.class);
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
            Exception exception = assertThrows("Ожидалось исключение, но ничего не было сгененрировано", expectedException, () -> new Lion(sex, feline));
            assertEquals(expectedException, exception.getClass());
        } else {
            try {
                Lion lion = new Lion(sex, feline);
                boolean actualHasMane = lion.doesHaveMane();
                assertEquals(String.format("Ожидался hasMane = %s, но получен = %s", expectedHasMane, actualHasMane), expectedHasMane, actualHasMane);
            } catch (Exception e) {
                fail(String.format("Не ожидалось исключение, но было перехвачено: %s %s", e.getClass().getSimpleName(), e.getMessage()));
            }
        }
    }
}