import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода  multiply() для класса Rational
@RunWith(Parameterized.class)
public class MultiplyTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0}*{1}={2} {3} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(1, 2), new Rational(3, 4), new Rational(3, 8), TestCase.POSITIVE, },
                        { new Rational(7, 5), new Rational(3, -5), new Rational(21, -25), TestCase.POSITIVE, },
                        { new Rational(5, -7), new Rational(-9, 11), new Rational(45, 77), TestCase.POSITIVE, },
                        { new Rational(0, 2), new Rational(1, 4), 0, TestCase.POSITIVE, },
                        { new Rational(-3, 5), new Rational(0, 3), 0, TestCase.POSITIVE, },
                        { new Rational(1, 1), new Rational(1, 2), new Rational(1, 2), TestCase.POSITIVE, },
                        { new Rational(-6, 7), new Rational(1, 1), new Rational(-6, 7), TestCase.POSITIVE, },
                        { new Rational(1, 1), new Rational(-1, 1), new Rational(-1, 1), TestCase.POSITIVE, },
                        { new Rational(1, -1), new Rational(-1, 1), new Rational(1, 1), TestCase.POSITIVE, },
                        { new Rational(1, 2147483647), new Rational(1, 2147483647), new Rational(1, 1),
                                TestCase.POSITIVE, },
                        { new Rational(1, 5), new Rational(6, 7), new Rational(6, 34), TestCase.NEGATIVE },
                });
    }

    // Поля класса
    // Ожидаемый результат умножения
    private Object expectedProduct;
    // Первый множитель класса Rational
    private Rational firstFactor;
    // Второй множитель класса Rational
    private Rational secondFactor;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public MultiplyTest(Rational firstFactor, Rational secondFactor, Object expectedProduct, TestCase testCase) {
        this.firstFactor = firstFactor;
        this.secondFactor = secondFactor;
        this.expectedProduct = expectedProduct;
        this.testCase = testCase;
    }

    // Метод для тестирования метода multiply()
    @Test
    public void multiplyReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("Multiplication test failed for rational " + firstFactor + " and " + secondFactor,
                    expectedProduct, firstFactor.multiply(secondFactor));
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("Multiplication test failed for rational " + firstFactor + " and " + secondFactor,
                        expectedProduct, firstFactor.multiply(secondFactor));
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        firstFactor = null;
        secondFactor = null;
        expectedProduct = null;
    }
}