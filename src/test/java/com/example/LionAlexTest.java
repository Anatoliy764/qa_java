package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {

    @Mock
    private Feline feline;

    private LionAlex lionAlex;

    @Before
    public void setUp() throws Exception {
        lionAlex = new LionAlex(feline);
    }

    @Test
    public void getKittens() {

        int expectedKittens = 1;
        int actualKittens = lionAlex.getKittens();

        String failMessage = String.format("У льва Алекса не было котят, но получено %s", expectedKittens, actualKittens);

        assertEquals(failMessage, expectedKittens, actualKittens);
    }

    @Test
    public void getFriends() {
        Set<String> expectedValue = Set.of("Марти", "Глория", "Мелман");
        Collection<String> actualValue = lionAlex.getFriends();

        String failMessage = String.format("Ожидалось что у льва Алекса в друзьях только %s, но получено %s", expectedValue, actualValue);

        assertTrue(failMessage, expectedValue.containsAll(actualValue));
    }

    @Test
    public void getPlaceOfLiving() {
        String expectedValue = "Нью-Йоркский зоопарк";
        String actualValue = lionAlex.getPlaceOfLiving();

        String failMessage = String.format("Ожидалось что лев Алекс живет в %s, но получено %s", expectedValue, actualValue);

        assertEquals(failMessage, expectedValue, actualValue);
    }
}