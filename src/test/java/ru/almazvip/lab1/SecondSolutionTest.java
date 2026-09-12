package ru.almazvip.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondSolutionTest {
    @Test
    public void secondSolution_mixedElements() {
        int[] arr = {3, 2, 2, 3};
        int val = 3;
        int newLength = SecondSolution.removeElementInplace(arr, val);

        assertEquals(2, newLength, "Длина должна быть 2");

        assertEquals(2, arr[0]);
        assertEquals(2, arr[1]);
    }

    @Test
    public void secondSolution_allElementsAreVal() {
        int[] arr = {2, 2, 2, 2};
        int val = 2;
        int newLength = SecondSolution.removeElementInplace(arr, val);

        assertEquals(0, newLength, "Если все элементы удалены, длина должна быть 0");
    }

    @Test
    public void secondSolution_noElementsAreVal() {
        int[] arr = {1, 4, 5, 6};
        int val = 99;
        int newLength = SecondSolution.removeElementInplace(arr, val);

        assertEquals(4, newLength, "Длина не должна измениться");

        assertEquals(1, arr[0]);
        assertEquals(4, arr[1]);
        assertEquals(5, arr[2]);
        assertEquals(6, arr[3]);
    }

    @Test
    public void secondSolution_emptyArray() {
        int[] arr = {};
        int val = 1;
        int newLength = SecondSolution.removeElementInplace(arr, val);

        assertEquals(0, newLength, "Для пустого массива длина всегда 0");
    }

    @Test
    public void secondSolution_orderUnchanged() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int newLength = SecondSolution.removeElementInplace(arr, val);

        assertEquals(5, newLength);

        int[] expectedPrefix = {0, 1, 3, 0, 4};
        for (int i = 0; i < newLength; i++) {
            assertEquals(expectedPrefix[i], arr[i], "Элемент на индексе " + i + " не совпадает");
        }
    }

    @Test
    public void secondSolution_nullArrayInput() {
        int val = 13;

        assertThrows(NullPointerException.class, () -> {
            SecondSolution.removeElementInplace(null, val);
        }, "Передача null должна вызывать NullPointerException");
    }
}
