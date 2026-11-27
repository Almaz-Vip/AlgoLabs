package ru.almazvip.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
    public static int getSubsequence(List<Integer> sequence) {
        List<Integer> dp = new ArrayList<>();
        int len = 0;

        for (int i = 0; i < sequence.size(); i++) {
            dp.add(1);

            int max = 1;

            for (int j = 0; j < i; j++) {
                if (sequence.get(i) > sequence.get(j) && max < dp.get(j) + 1) {
                    max = dp.get(j) + 1;
                }
            }

            dp.set(i, max);
            if (max > len) {
                len = max;
            }
        }

        int current = len;
        int last = 0;
        List<Integer> other_stupid_shit_array = new ArrayList<>();
        for (int i = sequence.size() - 1; i >= 0; i--) {
            if (dp.get(i) == current && current == len) {
                other_stupid_shit_array.add(sequence.get(i));
                last = sequence.get(i);
                current--;
                continue;
            }

            if (dp.get(i) == current && sequence.get(i) < last) {
                other_stupid_shit_array.add(sequence.get(i));
                last = sequence.get(i);
                current--;
            }
        }

        Collections.reverse(other_stupid_shit_array);
        for (int i = 0; i < other_stupid_shit_array.size(); i++) {
            System.out.printf("%d ", other_stupid_shit_array.get(i));
        }

        return len;
    }
}
