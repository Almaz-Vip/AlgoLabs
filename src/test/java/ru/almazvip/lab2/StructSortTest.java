package ru.almazvip.lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StructSortTest {
    final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public Student generateStudent() {
        var random = new Random();
        StringBuilder name = new StringBuilder();
        int length = random.nextInt(13) + 3;

        for (int i = 0; i < length; i++) {
            name.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }

        return new Student(name.toString(), random.nextInt(100));
    }

    @Test
    public void structSort_testRandomValues() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            students.add(generateStudent());
        }

        List<Student> studentsCopy = new ArrayList<>(students);
        var sort = new StructSort();

        sort.sort(studentsCopy);

        for (int i = 0; i < studentsCopy.size(); i++) {
            var studentsns = studentsCopy.get(i);
            var studentss = students.get(i);

            assertEquals(studentsns, studentss);

            System.out.printf(
                    "%s, %d == %s, %d%n",
                    studentsns.getName(), studentsns.getAge(),
                    studentss.getName(), studentss.getAge()
            );
        }
    }

    @Test
    public void structSort_testDefaultValues() {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Vasya", 21),
                new Student("Vasya", 19),
                new Student("Anton", 22),
                new Student("Antonio", 23)
        ));

        List<Student> original = new ArrayList<>(List.of(
                new Student("Anton", 22),
                new Student("Antonio", 23),
                new Student("Vasya", 19),
                new Student("Vasya", 21)
        ));

        var sort = new StructSort();

        sort.sort(students);

        for (int i = 0; i < students.size(); i++) {
            var original_student = original.get(i);
            var student = students.get(i);

            assertTrue(original_student.equals(student));

            System.out.printf(
                    "%s, %d == %s, %d%n",
                    original_student.getName(), original_student.getAge(),
                    student.getName(), student.getAge()
            );
        }
    }
}
