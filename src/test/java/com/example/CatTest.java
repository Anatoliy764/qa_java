package com.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private static Cat cat;

    @BeforeClass
    public static void setUp() {
        Feline feline = spy(Feline.class);
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

        assertTrue(failMessage, expectedFood.containsAll(actualFood));
    }
}