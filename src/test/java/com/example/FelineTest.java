package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private static final Feline FELINE = new Feline();

    @Test
    public void eatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = FELINE.eatMeat();

        String failMessage = String.format("Ожидалось что кошачьи едят %s, но получено %s", expectedFood, actualFood);

        assertTrue(failMessage, expectedFood.containsAll(actualFood));
    }

    @Test
    public void getFamily() {

        String expectedFamily = "Кошачьи";
        String actualFamily = FELINE.getFamily();

        String failMessage = String.format("Ожидалось что Feline это семейство %s, но получено %s", expectedFamily, actualFamily);

        assertEquals(failMessage, expectedFamily, actualFamily);
    }

    @Test
    public void getKittens() {

        int expectedKittens = 1;
        int actualKittens = FELINE.getKittens();

        String failMessage = String.format("Ожидалось количество котят %d, но получено %s", expectedKittens, actualKittens);

        assertEquals(failMessage, expectedKittens, actualKittens);
    }
}