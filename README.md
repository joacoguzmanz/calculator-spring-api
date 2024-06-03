# Calculator API

This is a simple calculator API built using Java and Spring Boot. It can perform basic arithmetic operations and some additional functions.

## Features

- Basic arithmetic operations: addition, subtraction, multiplication, and division.
- Additional functions: calculate the opposite of a number and calculate the percentage of a number.

## API Endpoints

- `/operations/calculate`: Perform basic arithmetic operations. Accepts a JSON payload with `firstNumber`, `operator`, and `secondNumber`.
- `/operations/calculateFunction`: Perform additional functions. Accepts a JSON payload with `function` and `singleNumber`.

## Usage

Send a POST request to the `/operations/calculate` endpoint with a JSON payload. For example:

```json
{
    "firstNumber": 5,
    "operator": "+",
    "secondNumber": 3
}
```

The response will be:

```json
8
```

Send a POST request to the `/operations/calculateFunction` endpoint with a JSON payload. For example:

```json
{
    "singleNumber": 5,
    "function": "opposite"
}
```

The response will be:

```json
-5
```

## Frontend Repository

The frontend for this project can be found at [Frontend Repository](https://github.com/joacoguzmanz/calculator-react-front).