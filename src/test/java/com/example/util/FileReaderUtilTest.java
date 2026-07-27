package com.example.util;

import com.example.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FileReaderUtilTest {

    @TempDir
    Path tempDir;

    @Test
    void readFromTextFileSkipsBlankLines() throws Exception {
        Path file = tempDir.resolve("in.txt");
        Files.write(file, List.of(
                "Иван;20;4",
                "",
                "   ",
                "Анна;21;5"));

        List<Student> result = FileReaderUtil.readFromTextFile(file.toString());

        assertEquals(2, result.size());
        assertEquals(new Student("Иван", 20, 4), result.get(0));
        assertEquals(new Student("Анна", 21, 5), result.get(1));
    }

    @Test
    void readFromMissingTextFileReturnsEmpty() {
        List<Student> result =
                FileReaderUtil.readFromTextFile(tempDir.resolve("missing.txt").toString());
        assertTrue(result.isEmpty());
    }

    @Test
    void readFromMissingBinaryFileReturnsEmpty() {
        List<Student> result =
                FileReaderUtil.readFromBinaryFile(tempDir.resolve("missing.dat").toString());
        assertTrue(result.isEmpty());
    }
}
