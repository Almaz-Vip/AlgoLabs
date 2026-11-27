package ru.almazvip;

import ru.almazvip.lab6.ApproximateSearch;
import ru.almazvip.lab7.LIS;
import ru.almazvip.lab8.PrefixSums;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> sequence = new ArrayList<>(List.of(7, 1, 4, 3, 3, 5, 4, 8, 6, 9));
//        LIS.getSubsequence(sequence);

        List<Integer> result = ApproximateSearch.search(List.of(1, 3, 5, 8, 10, 11, 14, 20), List.of(19, 9));
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
