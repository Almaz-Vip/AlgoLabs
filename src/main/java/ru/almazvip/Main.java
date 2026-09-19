package ru.almazvip;

import ru.almazvip.lab2.MergeSort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList<Integer>(List.of(5, 2, 6, 8, 3, 1, 9));
        MergeSort sort = new MergeSort();
        sort.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            IO.print(arr.get(i));
            IO.print(" ");
        }
    }
}
