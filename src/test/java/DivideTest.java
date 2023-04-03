import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода divide() для класса Rational
@RunWith(Parameterized.class)
public class DivideTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0}:{1}={2} {3} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(1, 2), new Rational(2, 3), new Rational(3, 4), TestCase.POSITIVE, },
                        { new Rational(-2, 3), new Rational(3, 4), new Rational(-8, 9), TestCase.POSITIVE, },
                        { new Rational(4, 5), new Rational(4, 5), new Rational(1, 1), TestCase.POSITIVE, },
                        { new Rational(1, 5), new Rational(-1, 5), new Rational(-1, 1), TestCase.POSITIVE, },
                        { new Rational(), new Rational(2, 3), 0, TestCase.POSITIVE, },
                        { new Rational(-2147483646, -2147483647), new Rational(1, 3),
                                new Rational(2147483642, 2147483647),
                                TestCase.POSITIVE, },
                        { new Rational(2147483644, 2147483647), new Rational(2147483647, -4),
                                new Rational(16, 1),
                                TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(4, 7), new Rational(2, 3), TestCase.NEGATIVE, },
                });
    }

    // Поля класса
    // Ожидаемый результат частного
    private Object expectedQuotient;
    // Делимое класса Rational
    private Rational dividend;
    // Делитель класса Rational
    private Rational divisor;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public DivideTest(Rational dividend, Rational divisor, Object expectedQuotient, TestCase testCase) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.expectedQuotient = expectedQuotient;
        this.testCase = testCase;
    }

    // Метод для тестирования метода divide()
    @Test
    public void divideReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Divide test failed for rational " + dividend + " and " + divisor,
                    expectedQuotient, dividend.divide(divisor));
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Divide test failed for rational " + dividend + " and " + divisor,
                        expectedQuotient, dividend.divide(divisor));
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        dividend = null;
        divisor = null;
        expectedQuotient = null;
    }
}