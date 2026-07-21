package com.example.util;

import com.example.model.Student;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {

    public static List<Student> readFromTextFile(String fileName) {
        List<Student> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    result.add(Student.fromCsvLine(line));
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения текстового файла: " + e.getMessage());
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static List<Student> readFromBinaryFile(String fileName) {
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            return (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка чтения бинарного файла: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
