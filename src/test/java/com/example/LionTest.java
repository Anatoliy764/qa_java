package com.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static Lion lion;

    @BeforeClass
    public static void setUp() {
        try {
            lion = new Lion("Самка", Mockito.spy(Feline.class));
        } catch (Exception e) {
            fail(String.format("Не ожидалось исключение, но было перехвачено: %s %s", e.getClass().getSimpleName(), e.getMessage()));
        }
    }

    @Test
    public void getKittens() {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFood() {
        try {
            List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
            List<String> actualFood = lion.getFood();

            String failMessage = String.format("Ожидалось что львы едят %s, но получено %s", expectedFood, actualFood);

            assertTrue(failMessage, expectedFood.containsAll(actualFood));
        } catch (Exception e) {
            fail(String.format("Не ожидалось исключение, но было перехвачено: %s %s", e.getClass().getSimpleName(), e.getMessage()));
        }
    }
}