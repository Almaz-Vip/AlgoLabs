package ru.almazvip.lab2;

import ru.almazvip.Sorting;

import java.util.ArrayList;
import java.util.List;

// Ошибки Stack overflow для 2к элементов в диапазон -2млрд до +2млрд
// Какой-то базовый случай не обработан

public class MergeSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size());
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> arr2 = new ArrayList<>(nums);

        int i = start, j = middle;
        for (int k = start; k < end; k++) {
            if (i < middle && j < end) {
                if (arr2.get(i) < arr2.get(j)) {
                    nums.set(k, arr2.get(i));
                    i++;
                } else {
                    nums.set(k, arr2.get(j));
                    j++;
                }
            } else if (i < middle) {
                nums.set(k, arr2.get(i));
                i++;
            } else {
                nums.set(k, arr2.get(j));
                j++;
            }
        }
    }

    private void slice(List<Integer> nums, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int middle = (start + end) / 2;

        slice(nums, start, middle);
        slice(nums, middle, end);

        merge(nums, start, middle, end);
    }
}
