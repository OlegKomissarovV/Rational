import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода lessOrEqual() для класса Rational
@RunWith(Parameterized.class)
public class LessOrEqualTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0} <= {1} == {2} {3} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(5, 7), new Rational(5, 7), true, TestCase.POSITIVE, },
                        { new Rational(-3, 4), new Rational(3, 4), true, TestCase.POSITIVE, },
                        { new Rational(), new Rational(), true, TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(-1, 2), false, TestCase.POSITIVE, },
                });
    }

    // Поля класса
    // Ожидаемый результат сравнения
    private boolean expectedResult;
    // Первый операнд класса Rational
    private Rational firstOperand;
    // Второй операнд класса Rational
    private Rational secondOperand;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public LessOrEqualTest(Rational firstOperand, Rational secondOperand, boolean expectedResult, TestCase testCase) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.expectedResult = expectedResult;
        this.testCase = testCase;
    }

    // Метод для тестирования метода lessOrEqual()
    @Test
    public void lessOrEqualReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("lessOrEqual test failed for rational " + firstOperand + " and " + secondOperand,
                    expectedResult, firstOperand.lessOrEqual(secondOperand));
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("lessOrEqual test failed for rational " + firstOperand + " and " + secondOperand,
                        expectedResult, firstOperand.lessOrEqual(secondOperand));
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        firstOperand = null;
        secondOperand = null;
    }
}