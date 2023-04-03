import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода less() для класса Rational
@RunWith(Parameterized.class)
public class LessTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0} < {1} == {2} {3} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(-1, 3), new Rational(1, 3), true, TestCase.POSITIVE, },
                        { new Rational(-4, -5), new Rational(3, -5), false, TestCase.POSITIVE, },
                        { new Rational(-6, 11), new Rational(-6, 7), false, TestCase.POSITIVE, },
                        { new Rational(5, 7), new Rational(5, 6), true, TestCase.POSITIVE, },
                        { new Rational(2, 5), new Rational(3, 4), false, TestCase.POSITIVE, },
                        { new Rational(2, -7), new Rational(5, 6), true, TestCase.POSITIVE, },
                        { new Rational(), new Rational(), false, TestCase.POSITIVE, },
                        { new Rational(), new Rational(0, 3), false, TestCase.POSITIVE, },
                        { new Rational(-5, 1), new Rational(), true, TestCase.POSITIVE, },
                        { new Rational(2147483645, -2147483648), new Rational(-2147483644, 2147483647), false,
                                TestCase.POSITIVE, },
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
    public LessTest(Rational firstOperand, Rational secondOperand, boolean expectedResult, TestCase testCase) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.expectedResult = expectedResult;
        this.testCase = testCase;
    }

    // Метод для тестирования метода less()
    @Test
    public void lessReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Less test failed for rational " + firstOperand + " and " + secondOperand,
                    expectedResult, firstOperand.less(secondOperand));
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Less test failed for rational " + firstOperand + " and " + secondOperand,
                        expectedResult, firstOperand.less(secondOperand));
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