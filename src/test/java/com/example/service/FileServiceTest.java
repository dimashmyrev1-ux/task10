package com.example.service;

import com.example.model.Student;
import com.example.util.FileReaderUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FileServiceTest {

    @TempDir
    Path folder;

    List<Student> students;

    @BeforeEach
    void setUp() {
        students = new ArrayList<>();
        students.add(new Student("Иван", 20, 4));
        students.add(new Student("Анна", 21, 5));
    }

    @Test
    void testTextFile() {
        String path = folder.resolve("students.txt").toString();

        FileService.writeToTextFile(students, path);
        List<Student> result = FileReaderUtil.readFromTextFile(path);

        assertEquals(2, result.size());
        assertEquals("Иван", result.get(0).getName());
        assertEquals(20, result.get(0).getAge());
    }

    @Test
    void testBinaryFile() {
        String path = folder.resolve("students.dat").toString();

        FileService.writeToBinaryFile(students, path);
        List<Student> result = FileReaderUtil.readFromBinaryFile(path);

        assertEquals(2, result.size());
        assertEquals("Анна", result.get(1).getName());
    }
}
