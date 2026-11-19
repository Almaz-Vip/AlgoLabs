package ru.almazvip.lab8;

import java.util.ArrayList;
import java.util.List;

public class PrefixSums {
    public final List<Integer> indexed;

    public PrefixSums(List<Integer> sums) {
        indexed = new ArrayList<>();
        indexed.add(0);

        for (int i = 0; i < sums.size(); i++) {
            indexed.add(indexed.get(i) + sums.get(i));
        }
    }

    public int sum(int left, int right) {
        return indexed.get(right + 1) - indexed.get(left);
    }
}
