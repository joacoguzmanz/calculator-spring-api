package com.dam.calculatorApi.controller;

import com.dam.calculatorApi.model.CalculationRequest;
import com.dam.calculatorApi.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Map;

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
        if (Double.isNaN(result)) {
            return new ResponseEntity<>(Map.of("error", "Error"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(df.format(result), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/calculateFunction")
    public ResponseEntity<Object> getFunctionResult(@RequestBody CalculationRequest request) {
        double result = calculatorService.calculateFunctions(request.getFunction(), request.getSingleNumber());
        return new ResponseEntity<>(df.format(result), HttpStatus.OK);
    }
}
