package ru.almazvip;

import ru.almazvip.lab2.InsertionSort;
import ru.almazvip.lab2.MergeSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        var random = new Random();

        for (int i = 0; i < 100000; i++) {
            items.add(random.nextInt());
        }

        List<Integer> sorted = new ArrayList<>(List.copyOf(items));
        var sort = new MergeSort();
        sort.sort(items);
        sorted.sort(null);

        System.out.println(sorted.equals(items));
    }
}

