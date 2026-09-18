package ru.almazvip.lab2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {
    private final InsertionSort sorter = new InsertionSort();

    @Test
    void insertionSort_testEmptyList() {
        var nums = new ArrayList<Integer>();

        sorter.sort(nums);
        assertEquals(
                List.of(),
                nums,
                "Пустой список не должен изменятся"
        );
    }

    @Test
    void insertionSort_testSingleElementList() {
        var nums = new ArrayList<>(List.of(42));

        sorter.sort(nums);
        assertEquals(
                List.of(42),
                nums,
                "Список из одного элемента не должен изменятся"
        );
    }

    @Test
    void insertionSort_testAlreadySortedList() {
        var nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        sorter.sort(nums);
        assertEquals(
                List.of(1, 2, 3, 4, 5),
                nums,
                "Уже отсортированный список не должен изменятся"
        );
    }

    @Test
    void insertionSort_testReverseSortedList() {
        var nums = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));

        sorter.sort(nums);
        assertEquals(
                List.of(1, 2, 3, 4, 5),
                nums,
                "Список, отсортированный в обратном порядке, должен поменять порядок"
        );
    }

    @Test
    void insertionSort_testRandomUnsortedList() {
        var nums = new ArrayList<>(Arrays.asList(3, 8, 1, 6, 2, 9, 4));

        sorter.sort(nums);
        assertEquals(
                List.of(1, 2, 3, 4, 6, 8, 9),
                nums,
                "Обычный неотсортированный список должен быть отсортирован по возрастанию"
        );
    }

    @Test
    void insertionSort_testListWithDuplicates() {
        var nums = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3));

        sorter.sort(nums);
        assertEquals(
                List.of(1, 1, 2, 3, 3, 4, 5, 5, 6, 9),
                nums,
                "Элементы-дубликаты должны стоять рядом"
        );
    }

    @Test
    void insertionSort_testListWithNegativeNumbers() {
        var nums = new ArrayList<>(Arrays.asList(10, -2, 0, -5, 3));

        sorter.sort(nums);
        assertEquals(
                List.of(-5, -2, 0, 3, 10),
                nums,
                "Отрицательные числа должны учитываться корректно"
        );
    }
}
