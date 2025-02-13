package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private static final Feline FELINE = new Feline();

    @Test
    public void eatMeat() {
        try {
            assertTrue(List.of("Животные", "Птицы", "Рыба").containsAll(FELINE.eatMeat()));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void getFamily() {
        assertEquals("Кошачьи", FELINE.getFamily());
    }

    @Test
    public void getKittens() {
        assertEquals(1, FELINE.getKittens());
    }
}