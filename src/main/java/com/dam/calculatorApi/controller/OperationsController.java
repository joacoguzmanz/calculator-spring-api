package com.dam.calculatorApi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    private StringBuilder expression = new StringBuilder();
    private double currentResult = 0.0;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/number")
    public String addNumber(@RequestParam double number) {
        currentResult = number;
        expression.append(number);
        return String.valueOf(number);
    }

    @GetMapping("/sum")
    public String sum(@RequestParam double number) {
        expression.append("+").append(number);
        currentResult += number;
        return String.valueOf(currentResult);
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam double number) {
        expression.append("-").append(number);
        currentResult -= number;
        return String.valueOf(currentResult);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam double number) {
        expression.append("*").append(number);
        currentResult *= number;
        return String.valueOf(currentResult);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam double number) {
        if (number == 0) {
            return "Error";
        } else {
            expression.append("/").append(number);
            currentResult /= number;
            return String.valueOf(currentResult);
        }
    }

    @GetMapping("/changeSign")
    public String changeSign() {
        currentResult *= -1;
        return String.valueOf(currentResult);
    }

    @GetMapping("/percentage")
    public String percentage() {
        currentResult /= 100;
        return String.valueOf(currentResult);
    }

    @GetMapping("/equal")
    public String equal() {
        expression.setLength(0);
        expression.append(currentResult);
        return String.valueOf(currentResult);
    }

    @GetMapping("/clear")
    public String clear() {
        expression.setLength(0);
        currentResult = 0.0;
        return "0";
    }
}
