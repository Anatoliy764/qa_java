package com.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private static Cat cat;

    @BeforeClass
    public static void setUp() {
        cat = new Cat(Mockito.mock(Feline.class));
    }

    @Test
    public void getSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() {
        try {
            assertTrue(List.of("Животные", "Птицы", "Рыба").containsAll(cat.getFood()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}