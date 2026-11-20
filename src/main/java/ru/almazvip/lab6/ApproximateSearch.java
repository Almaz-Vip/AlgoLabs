package ru.almazvip.lab6;

import java.util.ArrayList;
import java.util.List;

public class ApproximateSearch {
    public static List<Integer> search(List<Integer> values, List<Integer> requests) {
        var result = new ArrayList<Integer>();

        for (var request : requests) {
            int left = 0;
            int right = values.size() - 1;

            while (right - left > 1) {
                int mid = left + (right - left) / 2;
                if (values.get(mid) < request) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            if (Math.abs(values.get(left) - request) <= Math.abs(values.get(right) - request)) {
                result.add(values.get(left));
            } else {
                result.add(values.get(right));
            }
        }

        return result;
    }
}
