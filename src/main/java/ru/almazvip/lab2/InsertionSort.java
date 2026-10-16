package ru.almazvip.lab2;

import ru.almazvip.Sorting;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            int right = nums.get(i);
            int j;
            for (j = i; j > 0 && nums.get(j - 1) > right; j--) {
                nums.set(j, nums.get(j - 1));
            }
            nums.set(j, right);
        }
    }
}
