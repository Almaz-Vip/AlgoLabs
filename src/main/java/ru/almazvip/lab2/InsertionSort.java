package ru.almazvip.lab2;

import ru.almazvip.Sorting;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            for (int j = i; j > 0 && nums.get(j-1) > nums.get(j); j--) {
                int left = nums.get(j-1);
                nums.set(j-1, nums.get(j));
                nums.set(j, left);
            }
        }
    }
}
