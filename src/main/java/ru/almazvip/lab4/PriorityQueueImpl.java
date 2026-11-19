package ru.almazvip.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriorityQueueImpl implements PriorityQueue<Integer> {
    private final List<HeapNode> heap;
    private final Map<Long, Integer> positions; // Это для поиска элементов по операциям
    private long opCounter = 0; // счётчик операций

    PriorityQueueImpl() {
        heap = new ArrayList<>();
        positions = new HashMap<>();
    }

    @Override
    public void enqueue(Integer value) {
        opCounter++;

        HeapNode newNode = new HeapNode(opCounter, value);
        int index = heap.size();
        heap.add(newNode);
        positions.put(opCounter, index);

        siftUp(index);
    }

    @Override
    public Integer dequeueMax() {
        HeapNode maxNode = dequeueMaxNode();
        if (maxNode != null) {
            return maxNode.value;
        }
        return null;
    }

    @Override
    public void increment(long operation, Integer addition) {
        Integer index = positions.get(operation);

        if (index == null) {
            return;
        }

        HeapNode target = heap.get(index);
        target.value += addition;

        siftUp(index);
    }

    public HeapNode dequeueMaxNode() {
        if (heap.isEmpty()) {
            return null;
        }

        HeapNode maxNode = heap.getFirst();
        int last = heap.size() - 1;
        HeapNode lastNode = heap.get(last);

        heap.set(0, lastNode); // Переносим последний элемент в корень
        heap.remove(last);

        positions.put(lastNode.id, 0); // Обновляем позиции
        positions.remove(maxNode.id);

        if (!heap.isEmpty()) {
            siftDown(0);
        }

        return maxNode;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).value > heap.get(parent).value) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        HeapNode nodeI = heap.get(i);
        HeapNode nodeJ = heap.get(j);

        heap.set(i, nodeJ);
        heap.set(j, nodeI);

        positions.put(nodeJ.id, i);
        positions.put(nodeI.id, j);
    }

    private void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < heap.size() && heap.get(left).value > heap.get(largest).value) {
                largest = left;
            } else if (right < heap.size() && heap.get(right).value > heap.get(largest).value) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }
}
