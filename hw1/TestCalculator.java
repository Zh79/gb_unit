package hw_1;

import org.junit.jupiter.api.Test;
import seminars.first.Calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

//Задание 1. В классе Calculator создайте метод calculateDiscount, который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
// Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
// Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
// Не забудьте написать тесты для проверки этого поведения.
public class TestCalculator {

    @Test
    public void testNormalDiscount() {
        assertThat(Calculator.calculateDiscount(1000, 20)).isEqualTo(800);
    }

    @Test
    public void testZeroDiscount() {
        assertThat(Calculator.calculateDiscount(1000, 0)).isEqualTo(1000);
    }
    @Test
    public void testZeroSumProducts() {
        assertThat(Calculator.calculateDiscount(0, 50)).isEqualTo(0);
    }

    @Test
    public void testFloatSumProducts() {
        assertThat(Calculator.calculateDiscount(200.5, 50)).isEqualTo(100.25);
    }

    @Test
    public void testBigDiscount() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(1000, 100))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка не может быть больше 90%");
    }

    @Test
    public void testNegativeDiscount() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(1000, -20))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка не может быть меньше 0%");
    }
    @Test
    public void testNegativeDiscountAndSumProducts() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(-1000, -20))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка не может быть меньше 0%");
    }

    @Test
    public void testNegativeSumProduct() {
        assertThatThrownBy(() -> Calculator.calculateDiscount(-100, 20))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть меньше 0%");
    }
}