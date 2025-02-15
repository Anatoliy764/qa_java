package com.example;

import java.util.Collection;
import java.util.Set;

/**
 * Класс описывает льва Алекса из мультфидьма "Мадагаскар"
 * */
public class LionAlex extends Lion {

    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public Collection<String> getFriends() {
        return Set.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}
