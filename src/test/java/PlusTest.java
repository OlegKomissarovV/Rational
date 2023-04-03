import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода plus() для класса Rational
@RunWith(Parameterized.class)
public class PlusTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0}+{1}={2} {3} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(1, 2), new Rational(2, 3), new Rational(7, 6), TestCase.POSITIVE, },
                        { new Rational(-7, 8), new Rational(3, -7), new Rational(-73, 56), TestCase.POSITIVE, },
                        { new Rational(2, -2), new Rational(2, 2), 0, TestCase.POSITIVE, },
                        { new Rational(2, 3), new Rational(1, 3), new Rational(3, 3), TestCase.POSITIVE, },
                        { new Rational(3, -4), new Rational(-1, 4), new Rational(-4, 4), TestCase.POSITIVE, },
                        { new Rational(), new Rational(), 0, TestCase.POSITIVE, },
                        { new Rational(-1, 7), new Rational(), new Rational(-1, 7), TestCase.POSITIVE, },
                        { new Rational(), new Rational(2, 3), new Rational(2, 3), TestCase.POSITIVE, },
                        { new Rational(2147483647, -2147483648), new Rational(1, 3), new Rational(1, -2147483645),
                                TestCase.POSITIVE, },
                        { new Rational(2147483644, 2147483647), new Rational(1, 2147483647),
                                new Rational(-13, 2147483639),
                                TestCase.POSITIVE, },
                        { new Rational(1, 2), new Rational(3, 5), new Rational(3, 4), TestCase.NEGATIVE, },
                });
    }

    // Поля класса
    // Ожидаемый результат сложения
    private Object expectedSum;
    // Первое слагаемое класса Rational
    private Rational firstAddend;
    // Второе слагаемое класса Rational
    private Rational secondAddend;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public PlusTest(Rational firstAddend, Rational secondAddend, Object expectedSum, TestCase testCase) {
        this.firstAddend = firstAddend;
        this.secondAddend = secondAddend;
        this.expectedSum = expectedSum;
        this.testCase = testCase;
    }

    // Метод для тестирования метода plus()
    @Test
    public void plusReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Plus test failed for rational " + firstAddend + " and " + secondAddend,
                    expectedSum, firstAddend.plus(secondAddend));
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Plus test failed for rational " + firstAddend + " and " + secondAddend,
                        expectedSum, firstAddend.plus(secondAddend));
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        firstAddend = null;
        secondAddend = null;
        expectedSum = null;
    }
}