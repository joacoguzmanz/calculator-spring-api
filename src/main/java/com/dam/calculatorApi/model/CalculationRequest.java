package com.dam.calculatorApi.model;

public class CalculationRequest {

    private double firstNumber;
    private String operator;
    private double secondNumber;
    private String function;
    private double singleNumber;

    // getters and setters
    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public double getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(double singleNumber) {
        this.singleNumber = singleNumber;
    }
}
