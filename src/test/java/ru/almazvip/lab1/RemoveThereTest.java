package ru.almazvip.lab1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveThereTest {
    @Test
    public void removeThere_testMixedElements() {
        List<Integer> arr = new ArrayList<>(List.of(3, 2, 2, 3));
        int val = 3;
        int newLength = RemoveThere.removeElementInplace(arr, val);

        assertEquals(2, newLength, "Длина должна быть 2");

        assertEquals(2, arr.get(0));
        assertEquals(2, arr.get(1));
    }

    @Test
    public void removeThere_testAllElementsAreVal() {
        List<Integer> arr = new ArrayList<>(List.of(2, 2, 2, 2));
        int val = 2;
        int newLength = RemoveThere.removeElementInplace(arr, val);

        assertEquals(0, newLength, "Если все элементы удалены, длина должна быть 0");
    }

    @Test
    public void removeThere_testNoElementsAreVal() {
        List<Integer> arr = new ArrayList<>(List.of(1, 4, 5, 6));
        int val = 99;
        int newLength = RemoveThere.removeElementInplace(arr, val);

        assertEquals(4, newLength, "Длина не должна измениться");

        assertEquals(1, arr.get(0));
        assertEquals(4, arr.get(1));
        assertEquals(5, arr.get(2));
        assertEquals(6, arr.get(3));
    }

    @Test
    public void removeThere_testEmptyArray() {
        List<Integer> arr = List.of();
        int val = 1;
        int newLength = RemoveThere.removeElementInplace(arr, val);

        assertEquals(0, newLength, "Для пустого массива длина всегда 0");
    }

    @Test
    public void removeThere_testOrderUnchanged() {
        List<Integer> arr = new ArrayList<>(List.of(0, 1, 2, 2, 3, 0, 4, 2));
        int val = 2;
        int newLength = RemoveThere.removeElementInplace(arr, val);

        assertEquals(5, newLength);

        List<Integer> expectedPrefix = List.of(0, 1, 3, 0, 4);
        for (int i = 0; i < newLength; i++) {
            assertEquals(expectedPrefix.get(i), arr.get(i), "Элемент на индексе " + i + " не совпадает");
        }
    }

    @Test
    public void removeThere_testNullArrayInput() {
        int val = 13;

        assertThrows(NullPointerException.class, () -> {
            RemoveThere.removeElementInplace(null, val);
        }, "Передача null должна вызывать NullPointerException");
    }
}
