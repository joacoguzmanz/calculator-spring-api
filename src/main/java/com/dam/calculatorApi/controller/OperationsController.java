package com.dam.calculatorApi.controller;

import com.dam.calculatorApi.model.CalculationRequest;
import com.dam.calculatorApi.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    private final CalculatorService calculatorService;
    private final DecimalFormat df = new DecimalFormat("#.##");

    @Autowired
    public OperationsController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/calculate")
    public ResponseEntity<Object> getResult(@RequestBody CalculationRequest request) {
        double result = calculatorService.calculateResult(request.getFirstNumber(), request.getOperator(), request.getSecondNumber());
        return new ResponseEntity<>(df.format(result), HttpStatus.OK);
    }
}
