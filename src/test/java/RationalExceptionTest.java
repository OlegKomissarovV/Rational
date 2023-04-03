import org.junit.*;

// Класс для тестирования исключений объекта Rational
public class RationalExceptionTest {

    public Rational rational;

    // Метод для инициализации объекта Rational перед каждым тестом
    @Before
    public void setUp() {
        // Объект класса Rational
        rational = new Rational();
    }

    /*
     * Тестовый метод, который проверяет, что исключение ArithmeticException
     * выбрасывается при создании объекта Rational с нулевым знаменателем
     */
    @Test(expected = ArithmeticException.class)
    public void testThrowsArithmeticException() {
        rational = new Rational(1, 0);
        rational = rational.divide(new Rational(1, 0));
        rational = new Rational(1, 2);
        rational = rational.divide(new Rational(1, 0));
        rational = new Rational(-2147483648, 1);
        rational = rational.divide(new Rational(1, -2147483648));

    }

    /*
     * Тестовый метод, который проверяет, что исключение NullPointerException
     * выбрасывается при вызове методов с аргументом null
     */
    @Test(expected = NullPointerException.class)
    public void testThrowsNullException() {
        rational.plus(null);
        rational.multiply(null);
        rational.minus(null);
        rational.divide(null);
        rational.less(null);
    }

    // Метод для очистки объекта Rational после каждого теста
    @After
    public void tearDown() {
        rational = null;
    }
}