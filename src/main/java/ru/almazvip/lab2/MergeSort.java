package ru.almazvip.lab2;

import ru.almazvip.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size());
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> arr2 = List.copyOf(nums);

        int i = start, j = middle;
        for (int k = 0; k < end - start; k++) {
            if (i < middle && j < end) {
                if (arr2.get(i) < arr2.get(j)) {
                    nums.set(start + k, arr2.get(i));
                    i++;
                } else {
                    nums.set(start + k, arr2.get(j));
                    j++;
                }
            } else if (j < end) {
                nums.set(start + k, arr2.get(j));
                j++;
            } else {
                nums.set(start + k, arr2.get(i));
                i++;
            }
        }
    }

    private void slice(List<Integer> nums, int start, int end) {
        if (start == end-1) {
            return;
        }

        int middle = start + (end - start) / 2;

        slice(nums, start, middle);
        slice(nums, middle, end);

        merge(nums, start, middle, end);
    }
}
