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

### Tests
The DivideTest class contains a parameterized test to verify the `Rational divide(Rational rational)` method of the Rational class.

The EqualsTest class contains a parameterized test to verify the `boolean equals(Object obj)` method of the Rational class.

The GetDenominatorTest class contains a parameterized test to verify the `int getDenominator()` method of the Rational class.

The GetNumeratorTest class contains a parameterized test to verify the `int getNumerator()` method of the Rational class.

The LessOrEqualTest class contains a parameterized test to verify the `boolean lessOrEqual(Rational rational)` method of the Rational class.

The LessTest class contains a parameterized test to verify the `boolean less(Rational rational)` method of the Rational class.

The MinusTest class contains a parameterized test to verify the `Rational minus(Rational rational)` method of the Rational class.

The MultiplyTest class contains a parameterized test to verify the `Rational multiply(Rational rational)` method of the Rational class.

The PlusTest class contains a parameterized test to verify the `Rational plus(Rational rational)` method of the Rational class.

The RationalExceptionTest class contains tests to verify the exceptions thrown by the Rational class.

The ToStringTest class contains a parameterized test to verify the `String toString()` method of the Rational class.

The TestRunner class runs all the other test classes.

## Project Team
- Oleg Komissarov - QA Engineer

## Technologies
- JUnit version 4.13.2
- Java version 20

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
