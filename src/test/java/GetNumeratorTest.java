import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
// Класс для тестирования метода getNumerator() класса Rational
public class GetNumeratorTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: numerator of Rational {0} should be equal to {1} {2} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(), 0, TestCase.POSITIVE },
                        { new Rational(2147483647, 1), 2147483647, TestCase.POSITIVE },
                        { new Rational(0, 1), 0, TestCase.POSITIVE },
                        { new Rational(-2147483647, 1), -2147483647, TestCase.POSITIVE },
                        { new Rational(-2147483647, 1), 2147483647, TestCase.NEGATIVE },
                        { new Rational(2147483647, 1), -2147483647, TestCase.NEGATIVE },

                });
    }

    // Поля класса
    // Объект класса Rational
    private Rational rational;
    // Ожидаемое значение числителя
    private final int expectedNumerator;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public GetNumeratorTest(Rational rational, int expectedNumerator, TestCase testCase) {
        this.rational = rational;
        this.expectedNumerator = expectedNumerator;
        this.testCase = testCase;
    }

    // Тестовый метод, который проверяет, что метод getNumerator()
    // возвращает ожидаемое значение числителя
    @Test
    public void numeratorReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Numerator of Rational not corresponds to the expected value", expectedNumerator,
                    rational.getNumerator());
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Numerator of Rational not corresponds to the expected value", expectedNumerator,
                        rational.getNumerator());
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        rational = null;
    }
}