package ru.almazvip.lab3;

import ru.almazvip.Sorting;

import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int[] indices = new int[128];

        for (Integer val : nums) {
            indices[val] += 1;
        }

        int index = 0;
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < indices[i]; j++) {
                nums.set(index, i);
                index++;
            }
        }
    }
}
