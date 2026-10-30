package ru.almazvip.lab4;

public class MinStackImpl implements MinStack<Integer> {
    private StackLinkedList head = null;

    @Override
    public void push(Integer value) {
        int min;

        if (head == null) {
            min = value;
        } else {
            min = Math.min(head.min, value);
        }

        head = new StackLinkedList(value, min, head);
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }

        int value = head.val;
        head = head.next;
        return value;
    }

    @Override
    public Integer top() {
        if (head == null) {
            return null;
        }

        return head.val;
    }

    @Override
    public Integer min() {
        if (head == null) {
            return null;
        }

        return head.min;
    }
}
