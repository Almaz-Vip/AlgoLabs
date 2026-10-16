package ru.almazvip.lab3;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadixSortTest {
    private final RadixSort sorter = new RadixSort();

    @Test
    void countingSort_testDefaultValues() {
        var nums = new ArrayList<>(List.of(
                new BigInteger("98253615749725638769"),
                new BigInteger("13825728315012375300"),
                new BigInteger("64082371564298370519"),
                new BigInteger("42906201938519358334"),
                new BigInteger("50294672039481348059")
        ));

        sorter.sort(nums);
        assertEquals(
                List.of(
                        new BigInteger("13825728315012375300"),
                        new BigInteger("42906201938519358334"),
                        new BigInteger("50294672039481348059"),
                        new BigInteger("64082371564298370519"),
                        new BigInteger("98253615749725638769")
                ),
                nums,
                "Пустой список не должен изменятся"
        );
    }

    @Test
    void countingSort_testSingleElementList() {
        var nums = new ArrayList<>(List.of(new BigInteger("42424242424242424242")));

        sorter.sort(nums);
        assertEquals(
                List.of(new BigInteger("42424242424242424242")),
                nums,
                "Список из одного элемента не должен изменятся"
        );
    }
}
