package ru.almazvip.lab1;

public class SecondSolution {
    public static int removeElementInplace(int[] arr, int val) {
        if (arr == null) { throw new NullPointerException(); }

        int insert = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[insert] = arr[i];
                insert++;
            }
        }
        return insert;
    }
}
