package com.example.exception;

public class StudentFileException extends Exception {
    public StudentFileException(String message) {
        super(message);
    }


    public StudentFileException(String message, Throwable cause) {
        super(message, cause);
    }
}