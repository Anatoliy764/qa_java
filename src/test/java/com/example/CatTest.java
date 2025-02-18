package com.example;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private static Cat cat;

    @Before
    public void setUp() throws Exception {
        Feline feline = mock(Feline.class);

        when(feline.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();

        String failMessage = String.format("Кошка не мяукает. Ожидалось: \"%s\", но получено: \"%s\"", expectedSound, actualSound);

        assertEquals(failMessage, expectedSound, actualSound);
    }

    @Test
    public void getFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();

        String failMessage = String.format("Ожидалось что кошки едят %s, но получено %s", expectedFood, actualFood);

        assertEquals(failMessage, expectedFood, actualFood);
    }
}