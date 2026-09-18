package ru.almazvip.lab2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();

    @Test
    public void mergeSort_testRandomUnsortedList() {
        List<Integer> nums = new ArrayList<>(List.of(5, 2, 4, 1, 3));
        List<Integer> test = List.of(1, 2, 3, 4, 5);

        mergeSort.sort(nums);
        assertEquals(test, nums, "Обычный неотсортированный список должен быть отсортирован по возрастанию");
    }
}
