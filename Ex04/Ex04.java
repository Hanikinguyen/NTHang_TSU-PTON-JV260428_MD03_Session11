import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // HashMap lưu sản phẩm với key là id
        HashMap<Integer, Product> products = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Lọc sản phẩm có giá > 100");
            System.out.println("6. Tính tổng giá trị sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // =========================
                // 1. THÊM SẢN PHẨM
                // =========================
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    // Kiểm tra ID đã tồn tại
                    if (products.containsKey(id)) {
                        System.out.println("ID đã tồn tại!");
                        break;
                    }

                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập giá: ");
                    double price = scanner.nextDouble();

                    Product product = new Product(id, name, price);

                    products.put(id, product);

                    System.out.println("Thêm sản phẩm thành công!");
                    break;

                // =========================
                // 2. SỬA SẢN PHẨM
                // =========================
                case 2:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    if (!products.containsKey(updateId)) {
                        System.out.println("Không tìm thấy sản phẩm!");
                        break;
                    }

                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();

                    System.out.print("Nhập giá mới: ");
                    double newPrice = scanner.nextDouble();

                    Product updateProduct = products.get(updateId);

                    updateProduct.setName(newName);
                    updateProduct.setPrice(newPrice);

                    System.out.println("Cập nhật thành công!");
                    break;

                // =========================
                // 3. XÓA SẢN PHẨM
                // =========================
                case 3:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    int deleteId = scanner.nextInt();

                    if (products.containsKey(deleteId)) {
                        products.remove(deleteId);
                        System.out.println("Xóa sản phẩm thành công!");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }

                    break;

                // =========================
                // 4. HIỂN THỊ SẢN PHẨM
                // =========================
                case 4:
                    System.out.println("\n===== DANH SÁCH SẢN PHẨM =====");

                    if (products.isEmpty()) {
                        System.out.println("Danh sách sản phẩm đang trống!");
                    } else {
                        products.values()
                                .forEach(System.out::println);
                    }

                    break;

                // =========================
                // 5. LỌC GIÁ > 100
                // =========================
                case 5:
                    System.out.println(
                            "\n===== SẢN PHẨM CÓ GIÁ > 100 ====="
                    );

                    products.values()
                            .stream()
                            .filter(productItem ->
                                    productItem.getPrice() > 100)
                            .forEach(System.out::println);

                    break;

                // =========================
                // 6. TÍNH TỔNG GIÁ TRỊ
                // =========================
                case 6:
                    double total = products.values()
                            .stream()
                            .mapToDouble(Product::getPrice)
                            .sum();

                    System.out.println(
                            "Tổng giá trị sản phẩm: " + total
                    );

                    break;

                // =========================
                // 0. THOÁT
                // =========================
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        scanner.close();
    }
}

