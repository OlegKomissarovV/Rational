import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Класс тестирования метода toString() для класса Rational
@RunWith(Parameterized.class)
public class ToStringTest {
    // Перечисление типов тестовых случаев
    public enum TestCase {
        // Положительный тест
        POSITIVE,
        // Отрицательный тест
        NEGATIVE
    }

    // Коллекция тестовых данных
    @Parameters(name = "{index}: {0} is {1} {2} test")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][] {
                        { new Rational(1, 2), "1/2", TestCase.POSITIVE, },
                        { new Rational(3, 2), "1/2", TestCase.POSITIVE, },
                        { new Rational(-1, 2), "-1/2", TestCase.POSITIVE, },
                        { new Rational(1, -2), "-1/2", TestCase.POSITIVE, },
                        { new Rational(-1, -2), "1/2", TestCase.POSITIVE, },
                        { new Rational(2, 4), "1/2", TestCase.POSITIVE, },
                        { new Rational(-2, -4), "1/2", TestCase.POSITIVE, },
                        { new Rational(), "0/1", TestCase.POSITIVE, },
                        { new Rational(2147483646, -2147483648), "-1073741823/1073741824", TestCase.POSITIVE, },
                        { new Rational(), "0/0", TestCase.NEGATIVE, },
                        { new Rational(-1, 2), "1/2", TestCase.NEGATIVE, },
                });
    }

    // Поля класса
    // Ожидаемый результат строки, которую должен вернуть метод toString()
    private String expectedToStringResult;
    // Объект класса Rational
    private Rational rationalObject;
    // Тип тестового случая
    private final TestCase testCase;

    // Конструктор класса
    public ToStringTest(Rational rationalObject, String expectedToStringResult, TestCase testCase) {
        this.rationalObject = rationalObject;
        this.expectedToStringResult = expectedToStringResult;
        this.testCase = testCase;
    }

    // Метод для тестирования метода toString()
    @Test
    public void toStringReturnsExpectedResult() {
        if (testCase == TestCase.POSITIVE) {
            assertEquals("ToString test failed for rational " + rationalObject,
                    expectedToStringResult, rationalObject.toString());
        } else {
            assertThrows(AssertionError.class, () -> {
                assertEquals("ToString test failed for rational " + rationalObject,
                        expectedToStringResult, rationalObject.toString());
            });
        }
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        rationalObject = null;
    }
}