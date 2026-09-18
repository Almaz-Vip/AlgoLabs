package ru.almazvip.lab1;

// Задание 1.2

import java.util.List;

public class RemoveThere {
    public static int removeElementInplace(List<Integer> arr, int val) {
        int insert = 0;
        int toRemove = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != val) {
                arr.set(insert, arr.get(i));
                insert++;
            } else {
                toRemove++;
            }
        }

        for (int i = 0; i < toRemove; i++) {
            arr.removeLast();
        }

        return arr.size();
    }
}
