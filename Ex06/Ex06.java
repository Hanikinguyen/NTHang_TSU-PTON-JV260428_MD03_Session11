package Ex06;

import java.util.ArrayList;
import java.util.List;

public class Ex06 {

    public static void main(String[] args) {

        // Tạo danh sách sản phẩm
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1500));
        products.add(new Product("Chuột", 50));
        products.add(new Product("Bàn phím", 120));
        products.add(new Product("Tai nghe", 80));
        products.add(new Product("Điện thoại", 900));

        ProductProcessor processor = new ProductProcessorImpl();

        // Kiểm tra sản phẩm đắt tiền
        System.out.println("===== KIỂM TRA SẢN PHẨM ĐẮT TIỀN =====");

        if (processor.hasExpensiveProduct(products)) {

            System.out.println("Có sản phẩm có giá > 100:");

            for (Product product : products) {
                if (product.getPrice() > 100) {
                    System.out.println(product);
                }
            }

        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        // Tính tổng giá trị
        double total = processor.calculateTotalValue(products);

        System.out.println("\n===== TỔNG GIÁ TRỊ =====");
        System.out.println("Tổng giá trị sản phẩm: " + total);

        // In danh sách bằng static method
        System.out.println();

        ProductProcessor.printProductList(products);
    }
}
