package ru.almazvip.lab4;

public class StackLinkedList {
    public final int val;
    public final int min;
    public final StackLinkedList next;

    StackLinkedList(int val, int min, StackLinkedList next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
