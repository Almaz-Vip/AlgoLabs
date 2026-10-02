package ru.almazvip.lab2;

import ru.almazvip.Sorting;

import java.util.List;

// 20 секунд выполнения
// Нужно не перемещать элементы на каждую итерацию, а переместить за раз

// Не
//     *  *
// [5, 5, 1, 1, 1, 3, 4]
//  *  *
// [5, 1, 5, 1, 1, 3, 4]
// [1, 5, 5, 1, 1, 3, 4]

// А
//     *  *
// [5, 5, 1, 1, 1, 3, 4]
//  *,    *
// [5, 5, 1, 1, 1, 3, 4]
//     *  *
// [1, 5, 5, 1, 1, 3, 4]

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
