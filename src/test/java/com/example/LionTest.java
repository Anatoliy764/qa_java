package com.example;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static Lion lion;

    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {

        when(feline.getFood(anyString()))
                .thenAnswer((Answer<List<String>>) invocationOnMock -> {
                    String animalKind = invocationOnMock.getArgument(0);
                    if ("Травоядное".equals(animalKind)) {
                        return List.of("Трава", "Различные растения");
                    } else if ("Хищник".equals(animalKind)) {
                        return List.of("Животные", "Птицы", "Рыба");
                    } else {
                        throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
                    }
                });

        when(feline.getKittens())
                .thenReturn(1);

        lion = new Lion("Самка", feline);
    }

    @Test
    public void getKittens() {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();

        String failMessage = String.format("Ожидалось что львы едят %s, но получено %s", expectedFood, actualFood);

        assertEquals(failMessage, actualFood, expectedFood);
    }
}