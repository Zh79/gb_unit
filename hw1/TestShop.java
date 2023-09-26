package HW_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.first.Shop.Product;
import seminars.first.Shop.Shop;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//*Задание 2. Мы хотим улучшить функциональность нашего интернет-магазина.
// Ваша задача - добавить два новых метода в класс Shop:
// Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
// Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
//
// Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
// Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
// Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
//
// Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.
public class TestShop {
    List<Product> products;
    List<Product> sortedProducts;
    Product mostExpensiveProduct;

    @BeforeEach
    public void setUp() {
        products = List.of(new Product[]{
                new Product("apple", 25),
                new Product("banana", 22),
                new Product("orange", 15),
                new Product("mellon", 35)
        });
        sortedProducts = List.of(new Product[]{
                new Product("orange", 15),
                new Product("banana", 22),
                new Product("apple", 25),
                new Product("mellon", 35)
        });
        mostExpensiveProduct = new Product("mellon", 35);
    }

    @Test
    public void testSizeOfProducts() {
        Shop shop = new Shop();
        shop.setProducts(products);
        List<Product> res = shop.getProducts();

        assertThat(res.size()).isEqualTo(products.size());
    }

    @Test
    public void testShopCartContains() {
        Shop shop = new Shop();
        shop.setProducts(products);
        List<Product> res = shop.getProducts();

        for (int i = 0; i < res.size(); i++) {
            assertThat(res.get(i)).isEqualTo(products.get(i));
        }
    }

    @Test
    public void testSortProductsByPrice() {
        Shop shop = new Shop();
        shop.setProducts(products);
        List<Product> res = shop.sortProductsByPrice();

        for (int i = 0; i < sortedProducts.size(); i++) {
            assertThat(res.get(i).getCost()).isEqualTo(sortedProducts.get(i).getCost());
            assertThat(res.get(i).getTitle()).isEqualTo(sortedProducts.get(i).getTitle());
        }
    }

    @Test
    public void testGetMostExpensiveProduct() {
        Shop shop = new Shop();
        shop.setProducts(products);
        Product res = shop.getMostExpensiveProduct();

        assertThat(res.getCost()).isEqualTo(mostExpensiveProduct.getCost());
        assertThat(res.getTitle()).isEqualTo(mostExpensiveProduct.getTitle());
    }
}