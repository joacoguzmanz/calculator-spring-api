package com.dam.calculatorApi.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/sum")
    public String sum(@RequestParam List<Double> numbers) {
        double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        return String.valueOf(sum);
    }

    @GetMapping("/sub")
    public String sub(@RequestParam List<Double> numbers) {
        double result = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        return String.valueOf(result);
    }

    @GetMapping("/mul")
    public String mul(@RequestParam List<Double> numbers) {
        double result = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++) {
            result *= numbers.get(i);
        }
        return String.valueOf(result);
    }

    @GetMapping("/div")
    public String div(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return "Error";
        } else {
            return String.valueOf(a / b);
        }
    }

    @GetMapping("/changeSign")
    public String changeSign(@RequestParam double num) {
        return String.valueOf(-num);
    }

    @GetMapping("/percent")
    public String percent(@RequestParam double num) {
        return String.valueOf(num / 100);
    }
}
