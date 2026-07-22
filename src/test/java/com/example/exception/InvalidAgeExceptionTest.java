package com.example.exception;

import com.example.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidAgeExceptionTest {

    @Test
    void testNegativeAge() {
        assertThrows(InvalidAgeException.class, () -> new Student("Иван", -1, 4));
    }

    @Test
    void testTooBigAge() {
        assertThrows(InvalidAgeException.class, () -> new Student("Иван", 200, 4));
    }

    @Test
    void testSetAgeThrows() {
        Student student = new Student("Иван", 20, 4);
        assertThrows(InvalidAgeException.class, () -> student.setAge(-5));
    }

    @Test
    void testValidAge() {
        Student student = new Student("Иван", 20, 4);
        assertEquals(20, student.getAge());
    }

    @Test
      void testExceptionKeepsAge() {
        InvalidAgeException e = assertThrows(InvalidAgeException.class,
                () -> new Student("Иван", -1, 4));
        assertEquals(-1, e.getAge());
    }
}
