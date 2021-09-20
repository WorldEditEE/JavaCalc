package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("Введите математическое выражение : ");

        Scanner scanner = new Scanner(System.in);

        String mathExpression = scanner.nextLine().trim();

        calculator.doCalculate(mathExpression);
    }
}
