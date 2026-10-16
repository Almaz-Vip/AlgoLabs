package ru.almazvip.lab2;

import ru.almazvip.Sorting;

import java.util.ArrayList;
import java.util.List;

public class StructSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student right = students.get(i);
            int j;
            for (j = i; j > 0 && students.get(j - 1).compareTo(right) > 0; j--) {
                students.set(j, students.get(j - 1));
            }
            students.set(j, right);
        }
    }
}
