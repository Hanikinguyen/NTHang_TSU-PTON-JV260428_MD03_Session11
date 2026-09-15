package Ex06;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {

    // Abstract method
    double calculateTotalValue(List<Product> products);

    // Static method
    static void printProductList(List<Product> products) {
        System.out.println("===== DANH SÁCH SẢN PHẨM =====");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Default method
    default boolean hasExpensiveProduct(List<Product> products) {

        Predicate<Product> expensiveProduct =
                product -> product.getPrice() > 100;

        for (Product product : products) {
            if (expensiveProduct.test(product)) {
                return true;
            }
        }

        return false;
    }
}
