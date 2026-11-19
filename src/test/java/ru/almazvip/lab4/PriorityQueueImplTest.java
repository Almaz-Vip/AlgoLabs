package ru.almazvip.lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueImplTest {
    private PriorityQueueImpl queue;

    @BeforeEach
    void setUp() {
        queue = new PriorityQueueImpl();
    }

    @Test
    void testExampleFromTask() {
        queue.enqueue(10); // op 1
        queue.enqueue(42); // op 2
        queue.enqueue(9);  // op 3

        HeapNode first = queue.dequeueMaxNode();
        assertNotNull(first);
        assertEquals(2L, first.id);
        assertEquals(42, first.value);

        queue.increment(3, 10); // op 3: 9 + 10 = 19

        HeapNode second = queue.dequeueMaxNode();
        assertNotNull(second);
        assertEquals(3L, second.id);
        assertEquals(19, second.value);

        HeapNode third = queue.dequeueMaxNode();
        assertNotNull(third);
        assertEquals(1L, third.id);
        assertEquals(10, third.value);

        assertNull(queue.dequeueMaxNode());
    }

    @Test
    void testEmptyQueue() {
        assertNull(queue.dequeueMax());
        assertNull(queue.dequeueMaxNode());

        assertDoesNotThrow(() -> queue.increment(1, 100));
        assertNull(queue.dequeueMax());
    }

    @Test
    void testIncrementDeletedElement() {
        queue.enqueue(50); // op 1
        queue.enqueue(20); // op 2

        assertEquals(50, queue.dequeueMax());

        queue.increment(1, 1000);

        HeapNode remaining = queue.dequeueMaxNode();
        assertNotNull(remaining);
        assertEquals(2L, remaining.id);
        assertEquals(20, remaining.value);
    }

    @Test
    void testDuplicateValuesAndOperationNumbering() {
        queue.enqueue(5); // op 1
        queue.enqueue(5); // op 2
        queue.dequeueMax();

        // Номер новой вставки должен стать 3, а не 2
        queue.enqueue(5); // op 3
        queue.increment(3, 1);

        HeapNode max = queue.dequeueMaxNode();
        assertNotNull(max);
        assertEquals(3L, max.id);
        assertEquals(6, max.value);
    }
}