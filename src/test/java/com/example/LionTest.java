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
            fail(e.getMessage());
        }
    }

    @Test
    public void getKittens() {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFood() {
        try {
            assertTrue(List.of("Животные", "Птицы", "Рыба").containsAll(lion.getFood()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}