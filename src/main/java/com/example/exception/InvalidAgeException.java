package com.example.exception;

public class InvalidAgeException extends RuntimeException {

    private final int age;
    private final int minAge;
    private final int maxAge;

    public InvalidAgeException(int age, int minAge, int maxAge) {
        this(age, minAge, maxAge, null);
    }

    public InvalidAgeException(int age, int minAge, int maxAge, Throwable cause) {
        super(buildMessage(age, minAge, maxAge), cause);
        this.age = age;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    private static String buildMessage(int age, int minAge, int maxAge) {

        return "Некорректный возраст: " + age + ". Допустимый диапазон: " + minAge + ".." + maxAge;
    }

    public int getAge() {
        return age;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }
}
