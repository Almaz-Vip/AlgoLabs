package ru.almazvip.lab1;

// Задание 1.2

import java.util.List;

public class RemoveThere {
    public static int removeElementInplace(List<Integer> arr, int val) {
        var iter = arr.iterator();

        while (iter.hasNext()) {
            if (iter.next() == val) {
                iter.remove();
            }
        }

        return arr.size();
    }
}
