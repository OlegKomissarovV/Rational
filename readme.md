# About the Project
This repository was created as part of the "QA Mobile" course at Tinkoff Fintech, Spring 2023.

## Project Description
### Rational
The Rational class provides functionality for working with rational numbers, which can be represented as a fraction where the numerator and denominator are integers. Examples of rational numbers are 1/2, 3/4, -5/2.

The class allows creating objects of rational numbers with specified numerator and denominator or with default values (0/1).

When attempting to create a fraction with a zero denominator, an `ArithmeticException("division by zero !")` exception is thrown.

If the fraction is negative, a minus sign is placed before the numerator.

When creating a fraction, it is reduced if possible. For example, the fraction 5/10 will be reduced to 1/2.

The class also provides functionality for performing basic operations with rational numbers:
- addition, subtraction, multiplication, and division;
- comparison: equal, less than, less than or equal to.

When attempting to divide by zero, an `ArithmeticException("division by zero !")` exception is thrown.

## Project Team
- Oleg Komissarov - QA Engineer

## Technologies
- JUnit version 4.13.2
- Java version 17

## Instructions for Running the Project
### Cloning the Project
To clone the project, use the following command:

```bash
git clone https://github.com/your_username/Rational.git
```

### Running the Project
Before running the project, ensure that the Rational.jar file is in the root directory of the project.

To run the project, execute the following command:
```bash
java -jar Rational.jar
```