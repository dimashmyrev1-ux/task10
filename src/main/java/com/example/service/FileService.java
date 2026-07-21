package com.example.service;

import com.example.model.Student;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;


public class FileService {

    public static void writeToTextFile(List<Student> students, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                writer.write(s.toCsvLine());
                writer.newLine();
            }
            System.out.println("Данные успешно записаны в " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка записи в текстовый файл: " + e.getMessage());
        }
    }

    public static void writeToBinaryFile(List<Student> students, String fileName) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            out.writeObject(students);
            System.out.println("Данные успешно записаны в " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка записи в бинарный файл: " + e.getMessage());
        }
    }
}
