package com.example.service;

import com.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamAPITest {

    List<Student> students;

    @BeforeEach
    void setUp() {
        students = new ArrayList<>();
        students.add(new Student("Иван", 20, 4));
        students.add(new Student("Анна", 21, 5));
        students.add(new Student("Олег", 19, 3));
    }

    @Test
    void testFilter() {
        List<Student> result = StreamAPI.filterByGradeAbove(students, 3);
        assertEquals(2, result.size());
    }

    @Test
    void testSortByName() {
        List<Student> result = StreamAPI.sortByName(students);
        assertEquals("Анна", result.get(0).getName());
        assertEquals("Иван", result.get(1).getName());
        assertEquals("Олег", result.get(2).getName());
    }

    @Test
    void testSortByAge() {
        List<Student> result = StreamAPI.sortByAge(students);
        assertEquals(19, result.get(0).getAge());
        assertEquals(20, result.get(1).getAge());
        assertEquals(21, result.get(2).getAge());
    }

    @Test
    void testAverage() {
        double avg = StreamAPI.averageGrade(students);
        assertEquals(4.0, avg);   // (4 + 5 + 3) / 3 = 4.0
    }

    @Test
    void testGroup() {
        Map<Integer, List<Student>> groups = StreamAPI.groupByGrade(students);
        assertEquals(3, groups.size());
        assertEquals(1, groups.get(4).size());
    }
}
