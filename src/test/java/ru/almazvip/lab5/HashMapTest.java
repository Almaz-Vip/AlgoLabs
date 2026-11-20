package ru.almazvip.lab5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    @Test
    void hashMapTest_testEmptyList() {
        HashMapImpl map = new HashMapImpl();
        map.put("Porno siski piski", "qweqweqwe");
        System.out.println(map.getValue("Porno siski piski"));
        map.put("Porno siski piski", "qweqweqw1e");
        System.out.println(map.getValue("Porno siski piski"));
        map.delete("Porno siski piski");
        System.out.println(map.getValue("Porno siski piski"));
    }
}