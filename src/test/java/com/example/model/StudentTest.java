package com.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Иван", 20, 4);
    }

    @Test
    void testConstructor() {
        assertEquals("Иван", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(4, student.getGrade());
    }

    @Test
    void testGetters() {
        assertEquals("Иван", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(4, student.getGrade());
    }

    @Test
    void testSetters() {
        student.setName("Пётр");
        student.setAge(25);
        student.setGrade(5);

        assertEquals("Пётр", student.getName());
        assertEquals(25, student.getAge());
        assertEquals(5, student.getGrade());
    }

    @Test
    void testToString() {
        assertEquals("Student{name='Иван', age=20, grade=4}", student.toString());
    }

    @Test
    void testEquals() {
        Student other = new Student("Иван", 20, 4);
        assertTrue(student.equals(other));
    }

    @Test
    void testToCsvLine() {
        assertEquals("Иван;20;4", student.toCsvLine());
    }

    @Test
    void testFromCsvLine() {
        Student s = Student.fromCsvLine("Анна;21;5");
        assertEquals("Анна", s.getName());
        assertEquals(21, s.getAge());
        assertEquals(5, s.getGrade());
    }
}
