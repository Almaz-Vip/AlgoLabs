package ru.almazvip.lab3;

import ru.almazvip.Sorting;

import java.math.BigInteger;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        BigInteger ten = BigInteger.TEN.pow(20);
        for (
                BigInteger exponent = BigInteger.valueOf(1);
                exponent.compareTo(ten) < 0;
                exponent = exponent.multiply(BigInteger.TEN)
        ) {
            sortByDigits(nums, exponent);
        }
    }

    public void sortByDigits(List<BigInteger> nums, BigInteger exponent) {
        List<List<BigInteger>> buckets = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        for (BigInteger num : nums) {
            int digit = num.divide(exponent).mod(BigInteger.TEN).intValue(); // digit = (num / exponent) % 10                                                                                                                                     Пися попа
            buckets.get(digit).add(num);
        }

        nums.clear();
        for (var bucket : buckets) {
            nums.addAll(bucket);
        }
    }
}