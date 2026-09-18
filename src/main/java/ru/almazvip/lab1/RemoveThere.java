package ru.almazvip.lab1;

// Задание 1.2

import java.util.List;

public class RemoveThere {
    public static int removeElementInplace(List<Integer> arr, int val) {
        if (arr == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == val) {
                arr.remove(i);
                i--;
            }
        }

        return arr.size();
    }
}
