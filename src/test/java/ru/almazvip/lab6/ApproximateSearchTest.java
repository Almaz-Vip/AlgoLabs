package ru.almazvip.lab6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class ApproximateSearchTest {
    @Test
    public void testNormalValues() {
        List<Integer> values = new ArrayList<>(List.of(1, 3, 5, 8, 10, 11, 14, 20));
        List<Integer> requests = new ArrayList<>(List.of(19, 9));
        List<Integer> result = ApproximateSearch.search(values, requests);
        List<Integer> testValues = List.of(20, 8);

        for (int i = 0; i < result.size(); i++) {
            assertEquals(testValues.get(i), result.get(i));
        }
    }
}
