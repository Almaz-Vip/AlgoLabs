package ru.almazvip.lab2;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        if (this.name.equals(other.name)) {
            if (this.age > other.age) {
                return 1;
            } else if (this.age < other.age) {
                return -1;
            }
            return 0;
        }
        return this.name.compareTo(other.name);
    }

    public boolean equals(Student other) {
        return this.name.equals(other.name) && this.age == other.age;
    }
}
