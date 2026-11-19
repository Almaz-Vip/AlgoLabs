package ru.almazvip;

import ru.almazvip.lab8.PrefixSums;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<Integer> sums = new ArrayList<>(List.of(1, 4, 3, -6, 2, 6, -8, 2, 3, 5));
        PrefixSums prefixSums = new PrefixSums(sums);

        System.out.println(prefixSums.sum(4, 4));
    }
}
