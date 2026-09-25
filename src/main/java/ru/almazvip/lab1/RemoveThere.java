package ru.almazvip.lab1;

import java.util.List;

// Задание 1.2

public class RemoveThere {
    public static int removeElementInplace(List<Integer> arr, int val) {
        int insert = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != val) {
                arr.set(insert, arr.get(i));
                insert++;
            }
        }

        return insert;
    }
}
