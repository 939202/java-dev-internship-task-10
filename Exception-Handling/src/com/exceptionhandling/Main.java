package com.exceptionhandling;

import java.util.Scanner;

public class Main {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to register.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Runtime exception example
            int result = 10 / age;

            validateAge(age);

            System.out.println("Registration successful!");

        } catch (InvalidAgeException e) {
            System.err.println("Custom Exception Caught: " + e.getMessage());

        } catch (ArithmeticException e) {
            System.err.println("Runtime Exception: Division by zero is not allowed.");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("General Exception: Invalid input.");
            e.printStackTrace();

        } finally {
            scanner.close();
            System.out.println("Program execution completed (finally block executed).");
        }
    }
}
