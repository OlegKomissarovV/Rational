import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода minus() для класса Rational
@RunWith(Parameterized.class)
public class MinusTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0}-{1}={2} {3} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(3, 2), new Rational(1, 3), new Rational(7, 6), TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(-4, 5), new Rational(13, 10), TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(1, 2), 0, TestCase.POSITIVE, },
                        { new Rational(5, 4), new Rational(1, 4), new Rational(3, 3), TestCase.POSITIVE, },
                        { new Rational(-3, 2), new Rational(-1, 2), new Rational(-1, 1), TestCase.POSITIVE, },
                        { new Rational(), new Rational(), 0, TestCase.POSITIVE, },
                        { new Rational(-1, 7), new Rational(), new Rational(-1, 7), TestCase.POSITIVE, },
                        { new Rational(), new Rational(2, 3), new Rational(-2, 3), TestCase.POSITIVE, },
                        { new Rational(-2147483646, -2147483647), new Rational(1, 3), new Rational(-1, 429496729),
                                TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(3, 5), new Rational(-2, 3), TestCase.NEGATIVE, },
                });
    }

    // Поля класса
    // Ожидаемый результат разности
    private Object expectedDifference;
    // Уменьшаемое класса Rational
    private Rational minuend;
    // Вычитаемое класса Rational
    private Rational subtrahend;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public MinusTest(Rational minuend, Rational subtrahend, Object expectedDifference, TestCase testCase) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
        this.expectedDifference = expectedDifference;
        this.testCase = testCase;
    }

    // Метод для тестирования метода minus()
    @Test
    public void minusReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Minus test failed for rational " + minuend + " and " + subtrahend,
                    expectedDifference, minuend.minus(subtrahend));
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Minus test failed for rational " + minuend + " and " + subtrahend,
                        expectedDifference, minuend.minus(subtrahend));
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        minuend = null;
        subtrahend = null;
        expectedDifference = null;
    }
}