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
// Класс для тестирования метода getDenominator() класса Rational
public class GetDenominatorTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: denominator of Rational {0} should be equal to {1} {2} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(), 1, TestCase.POSITIVE },
                        { new Rational(1, 2147483647), 2147483647, TestCase.POSITIVE },
                        { new Rational(1, -2147483647), 2147483647, TestCase.POSITIVE },
                        { new Rational(1, 2147483647), -2147483647, TestCase.NEGATIVE },
                });
    }

    // Поля класса
    // Объект класса Rational
    private Rational rational;
    // Ожидаемое значение знаменателя
    private final int expectedDenominator;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public GetDenominatorTest(Rational rational, int expectedDenominator, TestCase testCase) {
        this.rational = rational;
        this.expectedDenominator = expectedDenominator;
        this.testCase = testCase;
    }

    // Тестовый метод, который проверяет, что метод getDenominator()
    // возвращает ожидаемое значение знаменателя
    @Test
    public void denominatorReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Denominator of Rational not corresponds to the expected value", expectedDenominator,
                    rational.getDenominator());
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Denominator of Rational not corresponds to the expected value", expectedDenominator,
                        rational.getDenominator());
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        rational = null;
    }
}