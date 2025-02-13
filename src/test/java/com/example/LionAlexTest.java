package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
        assertEquals(0, lionAlex.getKittens());
    }

    @Test
    public void getFriends() {
        assertTrue(Set.of("Марти", "Глория", "Мелман").containsAll(lionAlex.getFriends()));
    }

    @Test
    public void getPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }
}