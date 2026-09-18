package ru.almazvip.lab2;

import ru.almazvip.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }

    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;

        slice(nums, start, middle);
        slice(nums, middle + 1, end);

        merge(nums, start, middle, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> merged = new ArrayList<>(end - start + 1);

        int left = start;
        int right = middle + 1;

        while (left <= middle && right <= end) {
            if (nums.get(left) <= nums.get(right)) {
                merged.add(nums.get(left++));
            } else {
                merged.add(nums.get(right++));
            }
        }

        while (left <= middle) {
            merged.add(nums.get(left++));
        }

        while (right <= end) {
            merged.add(nums.get(right++));
        }

        for (int i = 0; i < merged.size(); i++) {
            nums.set(start + i, merged.get(i));
        }
    }
}
