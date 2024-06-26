package com.dam.calculatorApi.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculateResult(double firstNumber, String operator, double secondNumber) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "X" -> firstNumber * secondNumber;
            case "÷" -> {
                if (secondNumber == 0) {
                    yield Double.NaN;
                }
                yield firstNumber / secondNumber;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public double calculateFunctions(String function, double number) {
        return switch (function) {
            case "opposite" -> number * -1;
            case "%" -> number / 100;
            default -> throw new IllegalArgumentException("Invalid function: " + function);
        };
    }
}
