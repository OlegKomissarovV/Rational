import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода equals() для класса Rational
@RunWith(Parameterized.class)
public class EqualsTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0} == {1} == {2} {3} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(1, 2), null, false, TestCase.POSITIVE, },
                        { new Rational(3, 4), '$', false, TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(1, -2), false, TestCase.POSITIVE, },
                        { new Rational(3, 4), new Rational(3, 5), false, TestCase.POSITIVE, },
                        { new Rational(5, -8), new Rational(5, -7), false, TestCase.POSITIVE, },
                        { new Rational(-2, 9), new Rational(4, 9), false, TestCase.POSITIVE, },
                        { new Rational(4, 5), new Rational(3, 5), false, TestCase.POSITIVE, },
                        { new Rational(-7, -10), new Rational(-3, -10), false, TestCase.POSITIVE, },
                        { new Rational(4, -7), new Rational(5, -9), false, TestCase.POSITIVE, },
                        { new Rational(-2, 5), new Rational(-3, 7), false, TestCase.POSITIVE, },
                        { new Rational(4, -5), new Rational(-5, 7), false, TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(1, 2), true, TestCase.POSITIVE, },
                        { new Rational(-3, -4), new Rational(-3, -4), true, TestCase.POSITIVE, },
                        { new Rational(), new Rational(), true, TestCase.POSITIVE, },
                        { new Rational(-7, 8), new Rational(-7, 8), true, TestCase.POSITIVE, },
                        { new Rational(2, -3), new Rational(2, -3), true, TestCase.POSITIVE, },
                        { new Rational(1, 1), new Rational(1, 1), true, TestCase.POSITIVE, },
                        { new Rational(-2147483648, 2147483647), new Rational(-2147483648, 2147483647), true,
                                TestCase.POSITIVE, },
                });
    }

    // Поля класса
    // Ожидаемый результат сравнения
    private boolean expectedResult;
    // Делимое класса Rational
    private Rational firstOperand;
    // Объект второго операнд
    private Object secondOperand;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public EqualsTest(Rational firstOperand, Object secondOperand, boolean expectedResult, TestCase testCase) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.expectedResult = expectedResult;
        this.testCase = testCase;
    }

    // Метод для тестирования метода equals()
    @Test
    public void equalsReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Equals test failed for rational " + firstOperand + " and " + secondOperand,
                    expectedResult, firstOperand.equals(secondOperand));
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Equals test failed for rational " + firstOperand + " and " + secondOperand,
                        expectedResult, firstOperand.equals(secondOperand));
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