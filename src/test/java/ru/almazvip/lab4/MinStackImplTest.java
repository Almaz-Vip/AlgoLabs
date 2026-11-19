package ru.almazvip.lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinStackImplTest {
    @Test
    void countingSort_testEmptyList() {
        MinStack<Integer> minStack = new MinStackImpl();
        minStack.push(42);
        assertEquals(42, minStack.top(), "Первое значение не совпадает");
        assertEquals(42, minStack.min(), "Первое минимальное значение не совпадает");
        minStack.push(12);
        assertEquals(12, minStack.min(), "Второе минимальное значение не совпадает");
        minStack.push(13);
        assertEquals(13, minStack.top(), "Второе значение не совпадает");
        assertEquals(12, minStack.min(), "Третье минимальное значение не совпадает");
        minStack.pop();
        minStack.pop();
        assertEquals(42, minStack.min(), "Последнее минимальное значение не совпадает");
    }
}