package ru.almazvip.lab4;

public class Node {
    final int val;
    final int min;
    final Node next;

    Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
